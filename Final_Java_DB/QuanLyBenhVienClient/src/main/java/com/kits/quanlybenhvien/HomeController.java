package com.kits.quanlybenhvien;

import com.kits.quanlybenhvien.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class HomeController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping
    public String homePage(){
        return "homePage";
    }
    @PostMapping
    public String homePage(@RequestParam(value = "id",required = false)String id, Model model){
        Patient patient = rest.getForObject("http://localhost:8081/patient/{id}", Patient.class,id);
        List<Examination> examinations = Arrays.asList(rest.getForObject("http://localhost:8081/examination/search/{keyword}", Examination[].class,id));
        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine/search/{keyword}", DiseaseExamine[].class,id));
        List<Treatment> treatments= Arrays.asList(rest.getForObject("http://localhost:8081/treatment/search/{keyword}", Treatment[].class,id));
        List<MedList> medLists = Arrays.asList(rest.getForObject("http://localhost:8081/medlist/search/{keyword}", MedList[].class,id));
        List<ServiceList> serviceLists = Arrays.asList(rest.getForObject("http://localhost:8081/servicelist/search/{keyword}", ServiceList[].class,id));
        List<RepeatedDisease> repeatedDiseases = Arrays.asList(rest.getForObject("http://localhost:8081/repeateddisease/search/{keyword}", RepeatedDisease[].class,id));
        List<DiseaseSummary7> diseaseSummary7 = Arrays.asList(rest.getForObject("http://localhost:8081/diseasesummary7/search/{keyword}", DiseaseSummary7[].class,id));
        //List<ClinicRevenue> clinicRevenues = Arrays.asList(rest.getForObject("http://localhost:8081/homePage",ClinicRevenue[].class));
        model.addAttribute("patient",patient);
        model.addAttribute("examinations",examinations);
        model.addAttribute("diseaseExamines",diseaseExamines);
        model.addAttribute("treatments",treatments);
        model.addAttribute("medLists",medLists);
        model.addAttribute("serviceLists",serviceLists);
        model.addAttribute("repeatedDiseases",repeatedDiseases);
        model.addAttribute("diseaseSummary7",diseaseSummary7);


        return "homePagePatient";
    }
}
