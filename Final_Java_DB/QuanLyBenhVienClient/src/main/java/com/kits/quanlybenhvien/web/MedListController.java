package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.MedList;

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
@RequestMapping(path = "/medlist")
public class MedListController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationMedList(Model model){
        List<MedList> medlists = Arrays.asList(rest.getForObject("http://localhost:8081/medlist",MedList[].class));
        model.addAttribute("medlists",medlists);
        return "informationMedList";
    }
    @GetMapping("/add")
    public String addMedList(Model model){
        model.addAttribute("medlist",new MedList());
        return "formAddMedList";
    }
    @PostMapping
    public String addMedList(@RequestParam(value = "nameMed",required = false)String nameMed,
                             @RequestParam(value = "ID_Treatment",required = false) Integer ID_Treatment,
                             @RequestParam(value = "IDExamination",required = false) Integer IDExamination,
                             @RequestParam(value = "nameDisease",required = false)String nameDisease,
                             @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                             @RequestParam(value = "ID_DoctorCure",required = false)String ID_DoctorCure,
                             @RequestParam(value = "IDPatient",required = false)String IDPatient,
                             @RequestParam(value = "ID_Nurse",required = false)String ID_Nurse){
        MedList medlist = new MedList();
        medlist.setNameMed(nameMed);
        medlist.setID_Treatment(ID_Treatment);
        medlist.setIDExamination(IDExamination);
        medlist.setID_DoctorExamination(ID_DoctorExamination);
        medlist.setID_DoctorCure(ID_DoctorCure);
        medlist.setIDPatient(IDPatient);
        medlist.setNameDisease(nameDisease);
        medlist.setID_Nurse(ID_Nurse);

        log.info("New"+medlist);
        rest.postForObject("http://localhost:8081/medlist",medlist,MedList.class);
        return "redirect:/medlist";
    }
    @GetMapping("/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}")
    public String deleteMedList(@PathVariable(value = "id", required = false) String id,
                                @PathVariable(value = "id2", required = false) Integer id2,
                                @PathVariable(value = "id3", required = false) Integer id3,
                                @PathVariable(value = "id4", required = false) String id4,
                                @PathVariable(value = "id5", required = false) String id5,
                                @PathVariable(value = "id6", required = false) String id6,
                                @PathVariable(value = "id7", required = false) String id7,
                                @PathVariable(value = "id8", required = false) String id8,
                                Model model){
        try {
            rest.delete("http://localhost:8081/medlist/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}", id, id2, id3, id4, id5, id6, id7, id8);
        }catch( Exception e) {
            model.addAttribute("warning","Cannot delete! This prescription is currently in use.");
        }
        List<MedList> medlists = Arrays.asList(rest.getForObject("http://localhost:8081/medlist",MedList[].class));
        model.addAttribute("medlists",medlists);
        return "informationMedList";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<MedList> medLists = Arrays.asList(rest.getForObject("http://localhost:8081/medlist/search/{keyword}", MedList[].class,keyWord));
        model.addAttribute("medlists",medLists);
        return "informationMedList";
    }
}
