package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.DiseaseSummary7;

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
@RequestMapping(path = "/diseasesummary7")
public class DiseaseSummary7Controller {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationDiseaseSummary7(Model model){
        List<DiseaseSummary7> diseaseSummary7s = Arrays.asList(rest.getForObject("http://localhost:8081/diseasesummary7",DiseaseSummary7[].class));
        model.addAttribute("diseaseSummary7s",diseaseSummary7s);
        return "informationDiseaseSummary7";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String keyWord,Model model){
        System.out.println(keyWord);
        List<DiseaseSummary7> diseaseSummary7s = Arrays.asList(rest.getForObject("http://localhost:8081/diseasesummary7/search/{keyword}", DiseaseSummary7[].class,keyWord));
        model.addAttribute("diseaseSummary7s",diseaseSummary7s);
        return "informationDiseaseSummary7";
    }
}
