package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.ClinicRevenue;
import com.kits.quanlybenhvien.entity.Examination;
import com.kits.quanlybenhvien.entity.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/homePage")
public class ClinicRevenueController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationClinicRevenue(Model model){
        List<ClinicRevenue> clinicRevenues = Arrays.asList(rest.getForObject("http://localhost:8081/homePage",ClinicRevenue[].class));
        model.addAttribute("clinicRevenues",clinicRevenues);
       // List<CountPatient> countPatients = Arrays.asList(rest.getForObject("http://localhost:8081/homePage", CountPatient[].class));
       // model.addAttribute("countPatients",countPatients);

        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient/", Patient[].class));
        model.addAttribute("patients",patients.size());

        List<Examination> examinations = Arrays.asList(rest.getForObject("http://localhost:8081/examination/", Examination[].class));
        model.addAttribute("examinations",examinations.size());
        return "homePage";
    }
}
