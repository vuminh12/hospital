package com.kits.quanlybenhvien.web;


import com.kits.quanlybenhvien.entity.Doctor;
import com.kits.quanlybenhvien.entity.Med;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/med")
public class MedController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationMed(Model model){
        List<Med> meds = Arrays.asList(rest.getForObject("http://localhost:8081/med",Med[].class));
        System.out.println(meds);
        model.addAttribute("meds",meds);
        return "informationMed";
    }
    @GetMapping("/add")
    public String addMed(Model model){
        model.addAttribute("med", new Med());
        return "formAddMed";
    }

    @PostMapping()
    public String processDesign(@RequestParam("nameMed") String nameMed ,
                                @RequestParam("price") float price,
                                @RequestParam("usedFor") String usedFor,
                                Med med, Model model) {
        List<Med> meds = Arrays.asList(rest.getForObject("http://localhost:8081/med", Med[].class));
        for(Med med1 : meds){
            med.setNameMed(nameMed);
            med.setPrice(price);
            med.setUsedFor(usedFor);
            model.addAttribute("warningAdd", "Med is already exist!");
            model.addAttribute("meds",med);
            return "formAddMed";
        }
        med.setNameMed(nameMed);
        med.setPrice(price);
        med.setUsedFor(usedFor);
        log.info("New "+ med);
        rest.postForObject("http://localhost:8081/med", med, Med.class);
        return "redirect:/med";
    }

    @GetMapping("/delete/{id}")
    public String deleteMed(@PathVariable("id")String id, Model model) {
        try {
            rest.delete("http://localhost:8081/med/delete/{nameMed}", id);
        } catch(Exception e) {
            model.addAttribute("warning","Cannot delete! This medicine is currently in use.");
        }
        List<Med> meds = Arrays.asList(rest.getForObject("http://localhost:8081/med",Med[].class));
        System.out.println(meds);
        model.addAttribute("meds",meds);
        return "informationMed";
    }

    @GetMapping("/edit/{id}")
    public String editService(@PathVariable("id")String id,Model model){
        Med meds = rest.getForObject("http://localhost:8081/med/{nameMed}",Med.class,id);
        System.out.println(meds);
        model.addAttribute("med",meds);
        return "formUpdateMed";
    }
    @PostMapping("/edit/{nameMed}")
    public String editService( @PathVariable("nameMed") String nameMed ,
                               @RequestParam("price") float price,
                               @RequestParam("usedFor") String usedFor, Med med ) {
        med.setNameMed(nameMed);
        med.setPrice(price);
        med.setUsedFor(usedFor);

        log.info("New "+ med);
        rest.postForObject("http://localhost:8081/med", med, Med.class);
        return "redirect:/med";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "nameMed",required = false) String id,Model model){
        Med meds = rest.getForObject("http://localhost:8081/med/{nameMed}",Med.class,id);
        model.addAttribute("meds",meds);
        return "informationMed";
    }

}