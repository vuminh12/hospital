package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.DiseaseExamine;

import com.kits.quanlybenhvien.entity.Examination;
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
@RequestMapping(path = "/diseaseExamine")
public class DiseaseExamineController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationDiseaseExamine(Model model){
        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine",DiseaseExamine[].class));
        model.addAttribute("diseaseExamines",diseaseExamines);
        return "informationDiseaseExamine";
    }
    @GetMapping("/add")
    public String addDiseaseExamine(Model model){
        model.addAttribute("diseaseExamine",new DiseaseExamine());
        return "formAddDiseaseExamine";
    }
    @PostMapping
    public String addDiseaseExamine(@RequestParam(value = "ID_Examination",required = false) Integer ID_Examination,
                                    @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                                    @RequestParam(value = "ID_Patient",required = false)String ID_Patient,
                                    @RequestParam(value = "nameDisease",required = false)String nameDisease){
        DiseaseExamine diseaseExamine = new DiseaseExamine();
        diseaseExamine.setIDExamination(ID_Examination);
        diseaseExamine.setID_DoctorExamination(ID_DoctorExamination);
        diseaseExamine.setIDPatient(ID_Patient);
        diseaseExamine.setNameDisease(nameDisease);

        log.info("New"+diseaseExamine);
        rest.postForObject("http://localhost:8081/diseaseExamine",diseaseExamine,DiseaseExamine.class);
        return "redirect:/diseaseExamine";
    }
    @GetMapping("/delete/{id}/{id2}/{id3}/{id4}")
    public String deleteDiseaseExamine(@PathVariable(value = "id",required = false) String id,
                                       @PathVariable(value = "id2",required = false) String id2,
                                       @PathVariable(value = "id3",required = false) String id3,
                                       @PathVariable(value = "id4",required = false) String id4,
                                       Model model){
        try{
            rest.delete("http://localhost:8081/diseaseExamine/delete/{id}/{id2}/{id3}/{id4}",id,id2,id3,id4);
        }catch (Exception e){
            model.addAttribute("warning","This patient is currently in treatment process");
        }

        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine",DiseaseExamine[].class));
        model.addAttribute("diseaseExamines",diseaseExamines);
        return "informationDiseaseExamine";
    }
    @GetMapping("/edit/{id}/{id2}/{id3}/{id4}")
    public String editDiseaseExamine(@PathVariable(value = "id",required = false) String id,
                                     @PathVariable(value = "id2",required = false) String id2,
                                     @PathVariable(value = "id3",required = false) String id3,
                                     @PathVariable(value = "id4",required = false) String id4,
                                     Model model){
        DiseaseExamine diseaseExamine = rest.getForObject("http://localhost:8081/diseaseExamine/{id}/{id2}/{id3}/{id4}",DiseaseExamine.class,id,id2,id3,id4);
        model.addAttribute("diseaseExamine",diseaseExamine);
        return "formUpdateDiseaseExamine";
    }


    @PostMapping("/edit/{id}/{id2}/{id3}/{id4}")
    public String updateDiseaseExamine( @PathVariable(value = "id",required = false) Integer id,
                                        @PathVariable(value = "id2",required = false) String id2,
                                        @PathVariable(value = "id3",required = false) String id3,
                                        @PathVariable(value = "id4",required = false) String id4,DiseaseExamine diseaseExamine){
        rest.delete("http://localhost:8081/diseaseExamine/delete/{id}/{id2}/{id3}/{id4}",id,id2,id3,id4);

        diseaseExamine.setIDExamination(id);
        diseaseExamine.setID_DoctorExamination(id2);
        diseaseExamine.setIDPatient(id3);

        rest.postForObject("http://localhost:8081/diseaseExamine",diseaseExamine,DiseaseExamine.class);

        return "redirect:/diseaseExamine";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine/search/{keyword}", DiseaseExamine[].class,keyWord));
        model.addAttribute("diseaseExamines",diseaseExamines);
        return "informationDiseaseExamine";
    }
}
