package com.kits.quanlybenhvien.web;


import com.kits.quanlybenhvien.entity.Doctor;
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
@RequestMapping("/doctor")
public class DoctorController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationDocTor(Model model){
        List<Doctor> doctors = Arrays.asList(rest.getForObject("http://localhost:8081/doctor",Doctor[].class));
        System.out.println(doctors);
        model.addAttribute("doctors",doctors);
        return "informationDoctor";
    }
    @GetMapping("/add")
    public String addDoctor(Model model){
        model.addAttribute("doctor", new Doctor());
        return "formAddDoctor";
    }

    @PostMapping()
    public String processDesign(@RequestParam(value = "ID_Doctor",required = false) String id ,
                                @RequestParam(value = "identityNumber", required = false) String identity,
                                @RequestParam(value = "nameDoctor", required = false) String name,
                                @RequestParam(value = "DOB",required = false) String dob ,
                                @RequestParam(value = "address",required = false) String address,
                                @RequestParam(value = "exp",required = false) int exp,
                                @RequestParam(value = "diploma",required = false) String diploma ,
                                @RequestParam(value = "field",required = false) String field,
                                @RequestParam(value = "position",required = false) String position,
                                Doctor doctor, Model model) {
        List<Doctor> doctors = Arrays.asList(rest.getForObject("http://localhost:8081/doctor",Doctor[].class));
        for (Doctor doctor1:doctors) {
            if (id.equals(doctor1.getID_Doctor())) {
                doctor.setID_Doctor(id);
                doctor.setIdentityNumber(identity);
                doctor.setNameDoctor(name);
                doctor.setDOB(dob);
                doctor.setAddress(address);
                doctor.setExp(exp);
                doctor.setDiploma(diploma);
                doctor.setField(field);
                doctor.setPosition(position);
                log.info("New "+ doctor);
                model.addAttribute("warningAdd", "Doctor is already exist!");
                model.addAttribute("doctors",doctor);
                return "formAddDoctor";
            }
        }
        doctor.setID_Doctor(id);
        doctor.setIdentityNumber(identity);
        doctor.setNameDoctor(name);
        doctor.setDOB(dob);
        doctor.setAddress(address);
        doctor.setExp(exp);
        doctor.setDiploma(diploma);
        doctor.setField(field);
        doctor.setPosition(position);
        log.info("New "+ doctor);
        rest.postForObject("http://localhost:8081/doctor", doctor, Doctor.class);
        return "redirect:/doctor";
    }
    @PostMapping("/{id}")
    public String updateDesign(@PathVariable(value = "id",required = false) String id ,
                                @RequestParam(value = "identityNumber", required = false) String identity,
                                @RequestParam(value = "nameDoctor", required = false) String name,
                                @RequestParam(value = "DOB",required = false) String dob ,
                                @RequestParam(value = "address",required = false) String address,
                                @RequestParam(value = "exp",required = false) int exp,
                                @RequestParam(value = "diploma",required = false) String diploma ,
                                @RequestParam(value = "field",required = false) String field,
                                @RequestParam(value = "position",required = false) String position,
                                Doctor doctor) {
        doctor.setID_Doctor(id);
        doctor.setIdentityNumber(identity);
        doctor.setNameDoctor(name);
        doctor.setDOB(dob);
        doctor.setAddress(address);
        doctor.setExp(exp);
        doctor.setDiploma(diploma);
        doctor.setField(field);
        doctor.setPosition(position);
        log.info("New "+ doctor);
        rest.postForObject("http://localhost:8081/doctor", doctor, Doctor.class);
        return "redirect:/doctor";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id")String id, Model model) {
        try{
            rest.delete("http://localhost:8081/doctor/delete/{ID_Doctor}",id);
        }catch (Exception e){
            model.addAttribute("warning","Cannot delete! This doctor is currently attending in examination/treatment process");
        }

        List<Doctor> doctors = Arrays.asList(rest.getForObject("http://localhost:8081/doctor",Doctor[].class));
        System.out.println(doctors);
        model.addAttribute("doctors",doctors);
        return "informationDoctor";
    }
    @GetMapping("/edit/{id}")
    public String editDoctor(@PathVariable(value = "id",required = false)String id,Model model){
        Doctor doctor = rest.getForObject("http://localhost:8081/doctor/{id}",Doctor.class,id);
        model.addAttribute("doctor",doctor);
        return "formUpdateDoctor";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String id,Model model){
        Doctor doctor = rest.getForObject("http://localhost:8081/doctor/{id}", Doctor.class,id);
        model.addAttribute("doctors",doctor);
        return "informationDoctor";
    }
}