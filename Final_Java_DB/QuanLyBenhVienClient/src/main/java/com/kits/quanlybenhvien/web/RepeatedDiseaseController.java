package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.RepeatedDisease;

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
@RequestMapping(path = "/repeateddisease")
public class RepeatedDiseaseController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationRepeatedDisease(Model model){
        List<RepeatedDisease> repeatedDiseases = Arrays.asList(rest.getForObject("http://localhost:8081/repeateddisease",RepeatedDisease[].class));
        model.addAttribute("repeatedDiseases",repeatedDiseases);
        return "informationRepeatedDisease";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<RepeatedDisease> repeatedDiseases = Arrays.asList(rest.getForObject("http://localhost:8081/repeateddisease/search/{keyword}", RepeatedDisease[].class,keyWord));
        model.addAttribute("repeatedDiseases",repeatedDiseases);
        return "informationRepeatedDisease";
    }
}
