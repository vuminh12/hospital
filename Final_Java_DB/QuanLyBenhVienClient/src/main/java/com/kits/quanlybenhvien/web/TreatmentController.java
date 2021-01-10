package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.*;

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
@RequestMapping(path = "/treatment")
public class TreatmentController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationTreatment(Model model){
        List<Treatment> treatments = Arrays.asList(rest.getForObject("http://localhost:8081/treatment",Treatment[].class));
        model.addAttribute("treatments",treatments);
        return "informationTreatment";
    }
    @GetMapping("/add")
    public String addTreatment(Model model){
        model.addAttribute("treatment",new Treatment());
        return "formAddTreatment";
    }
    @PostMapping
    public String addTreatment(@RequestParam(value = "IDExamination",required = false) Integer IDExamination,
                               @RequestParam(value = "nameDisease",required = false)String nameDisease,
                               @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                               @RequestParam(value = "ID_DoctorCure",required = false)String ID_DoctorCure,
                               @RequestParam(value = "IDPatient",required = false)String IDPatient,
                               @RequestParam(value = "ID_Nurse",required = false)String ID_Nurse,
                               @RequestParam(value = "atTime",required = false)String atTime,
                               @RequestParam(value = "status",required = false)Boolean status){
        Treatment treatment = new Treatment();
        treatment.setIDExamination(IDExamination);
        treatment.setNameDisease(nameDisease);
        treatment.setID_DoctorExamination(ID_DoctorExamination);
        treatment.setID_DoctorCure(ID_DoctorCure);
        treatment.setIDPatient(IDPatient);
        treatment.setID_Nurse(ID_Nurse);
        treatment.setAtTime(atTime);
        treatment.setStatus(status);

        log.info("New"+treatment);
        rest.postForObject("http://localhost:8081/treatment",treatment,Treatment.class);
        return "redirect:/treatment";
    }

    @GetMapping("/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public String deleteTreatment(@PathVariable(value = "id", required = false) Integer id,
                                    @PathVariable(value = "id2", required = false) Integer id2,
                                    @PathVariable(value = "id3", required = false) String id3,
                                    @PathVariable(value = "id4", required = false) String id4,
                                    @PathVariable(value = "id5", required = false) String id5,
                                    @PathVariable(value = "id6", required = false) String id6,
                                    @PathVariable(value = "id7", required = false) String id7,
                                    Model model){
        try{
            rest.delete("http://localhost:8081/treatment/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}",id,id2,id3,id4,id5,id6,id7);
        }catch (Exception e){
            model.addAttribute("warning","Phai toi toi dam cho 2 cai");
        }

        List<Treatment> treatments = Arrays.asList(rest.getForObject("http://localhost:8081/treatment",Treatment[].class));
        model.addAttribute("treatments",treatments);
        return "informationTreatment";
    }
    @GetMapping("/edit/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public String editTreatment(@PathVariable(value = "id",required = false) Integer id,
                                @PathVariable(value = "id2",required = false) Integer id2,
                                @PathVariable(value = "id3",required = false) String id3,
                                @PathVariable(value = "id4",required = false) String id4,
                                @PathVariable(value = "id5",required = false) String id5,
                                @PathVariable(value = "id6",required = false) String id6,
                                @PathVariable(value = "id7",required = false) String id7,
                                Model model){
        Treatment treatment = rest.getForObject("http://localhost:8081/treatment/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}",Treatment.class,id,id2,id3,id4,id5,id6,id7);
        model.addAttribute("treatment",treatment);
        return "formUpdateTreatment";
    }

    @PostMapping("/edit/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public String updateTreatment(@PathVariable(value = "id",required = false) Integer id,
                                    @PathVariable(value = "id2",required = false) Integer id2,
                                    @PathVariable(value = "id3",required = false) String id3,
                                    @PathVariable(value = "id4",required = false) String id4,
                                    @PathVariable(value = "id5",required = false) String id5,
                                    @PathVariable(value = "id6",required = false) String id6,
                                    @PathVariable(value = "id7",required = false) String id7, Treatment treatment){
        treatment.setID_Treatment(id);
        treatment.setIDExamination(id2);
        treatment.setNameDisease(id3);
        treatment.setID_DoctorExamination(id4);
        treatment.setID_DoctorCure(id5);
        treatment.setIDPatient(id6);
        treatment.setID_Nurse(id7);


        rest.postForObject("http://localhost:8081/treatment",treatment,Treatment.class);

        return "redirect:/treatment";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<Treatment> treatments= Arrays.asList(rest.getForObject("http://localhost:8081/treatment/search/{keyword}", Treatment[].class,keyWord));
        model.addAttribute("treatments",treatments);
        return "informationTreatment";
    }
}
