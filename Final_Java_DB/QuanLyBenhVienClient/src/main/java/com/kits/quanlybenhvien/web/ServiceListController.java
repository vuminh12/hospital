package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.DiseaseExamine;
import com.kits.quanlybenhvien.entity.ServiceList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/servicelist")
public class ServiceListController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationServiceList(Model model){
        List<ServiceList> servicelists = Arrays.asList(rest.getForObject("http://localhost:8081/servicelist",ServiceList[].class));
        model.addAttribute("servicelists",servicelists);
        return "informationServiceList";
    }
    @GetMapping("/add")
    public String addServiceList(Model model){
        model.addAttribute("servicelist",new ServiceList());
        return "formAddServiceList";
    }
    @PostMapping
    public String addServiceList(@RequestParam(value = "nameService",required = false)String nameService,
                                 @RequestParam(value = "ID_Treatment",required = false) Integer ID_Treatment,
                                 @RequestParam(value = "IDExamination",required = false) Integer IDExamination,
                                 @RequestParam(value = "nameDisease",required = false)String nameDisease,
                                 @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                                 @RequestParam(value = "ID_DoctorCure",required = false)String ID_DoctorCure,
                                 @RequestParam(value = "IDPatient",required = false)String IDPatient,
                                 @RequestParam(value = "ID_Nurse",required = false)String ID_Nurse){
        ServiceList servicelist = new ServiceList();
        servicelist.setNameService(nameService);
        servicelist.setID_Treatment(ID_Treatment);
        servicelist.setIDExamination(IDExamination);
        servicelist.setID_DoctorExamination(ID_DoctorExamination);
        servicelist.setID_DoctorCure(ID_DoctorCure);
        servicelist.setIDPatient(IDPatient);
        servicelist.setNameDisease(nameDisease);
        servicelist.setID_Nurse(ID_Nurse);

        log.info("New"+servicelist);
        rest.postForObject("http://localhost:8081/servicelist",servicelist,ServiceList.class);
        return "redirect:/servicelist";
    }
    @GetMapping("/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}")
    public String deleteServiceList(@PathVariable(value = "id", required = false) String id,
                                    @PathVariable(value = "id2", required = false) Integer id2,
                                    @PathVariable(value = "id3", required = false) Integer id3,
                                    @PathVariable(value = "id4", required = false) String id4,
                                    @PathVariable(value = "id5", required = false) String id5,
                                    @PathVariable(value = "id6", required = false) String id6,
                                    @PathVariable(value = "id7", required = false) String id7,
                                    @PathVariable(value = "id8", required = false) String id8,
                                    Model model){
        try {
            rest.delete("http://localhost:8081/servicelist/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}", id, id2, id3, id4, id5, id6, id7, id8);
        } catch(Exception e) {
            model.addAttribute("warning","Cannot delete! This service list is currently in use");
        }
        List<ServiceList> servicelists = Arrays.asList(rest.getForObject("http://localhost:8081/servicelist",ServiceList[].class));
        System.out.println(servicelists);
        model.addAttribute("servicelists",servicelists);
        return "informationServiceList";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<ServiceList> serviceLists = Arrays.asList(rest.getForObject("http://localhost:8081/servicelist/search/{keyword}", ServiceList[].class,keyWord));
        model.addAttribute("servicelists",serviceLists);
        return "informationServiceList";
    }
}
