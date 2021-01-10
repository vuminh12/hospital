package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Doctor;
import com.kits.quanlybenhvien.entity.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/service")
public class ServiceController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationService(Model model){
        List<Service> services = Arrays.asList(rest.getForObject("http://localhost:8081/service",Service[].class));
        System.out.println(services);
        model.addAttribute("services",services);
        return "informationService";
    }
    @GetMapping("/add")
    public String addService(Model model){
        model.addAttribute("service", new Service());
        return "formAddService";
    }

    @PostMapping
    public String processDesign(@RequestParam("nameService") String nameService ,
                                @RequestParam("price") float price,
                                Service service, Model model ) {
        List<Service> services = Arrays.asList(rest.getForObject("http://localhost:8081/service", Service[].class));
        for(Service service1 : services){
            service.setNameService(nameService);
            service.setPrice(price);
            model.addAttribute("warningAdd", "Service is already exist!");
            model.addAttribute("services",service);
            return "formAddService";
        }
        service.setNameService(nameService);
        service.setPrice(price);
        log.info("New "+ service);
        rest.postForObject("http://localhost:8081/service", service, Service.class);
        return "redirect:/service";
    }
    @GetMapping("/delete/{nameService}")
    public String deleteMed(@PathVariable("nameService")String id, Model model) {
        try {
            rest.delete("http://localhost:8081/service/delete/{nameService}", id);
        } catch (Exception e) {
            model.addAttribute("warning","Cannot delete! This service is currently in use");
        }
        List<Service> services = Arrays.asList(rest.getForObject("http://localhost:8081/service",Service[].class));
        System.out.println(services);
        model.addAttribute("services",services);
        return "informationService";
    }
    @GetMapping("/edit/{nameService}")
    public String editService(@PathVariable("nameService")String nameService,Model model){
        Service services = rest.getForObject("http://localhost:8081/service/{nameService}",Service.class,nameService);
        System.out.println(services);
        model.addAttribute("service",services);
        return "formUpdateService";
    }

    @PostMapping("/edit/{nameService}")
    public String editService(@PathVariable("nameService") String nameService ,
                              @RequestParam("price") float price, Service service ) {
        service.setNameService(nameService);
        service.setPrice(price);
        log.info("New "+ service);
        rest.postForObject("http://localhost:8081/service", service,Service.class);
        return "redirect:/service";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "nameService",required = false) String id,Model model){
        Service service = rest.getForObject("http://localhost:8081/service/{nameService}",Service.class,id);
        model.addAttribute("services",service);
        return "informationService";
    }

}