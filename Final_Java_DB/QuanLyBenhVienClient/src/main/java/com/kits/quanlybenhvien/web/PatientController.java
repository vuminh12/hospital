package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Doctor;
import com.kits.quanlybenhvien.entity.Nurse;
import com.kits.quanlybenhvien.entity.Patient;
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
@RequestMapping(path = "/patient")
public class PatientController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationPatient(Model model){
        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient",Patient[].class));
        model.addAttribute("patients",patients);
        return "informationPatient";
    }
    @GetMapping("/add")
    public String addPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formAddPatient";
    }
    @PostMapping
    public String addPatient(@RequestParam(value = "ID_Patient",required = false) String id,
                             @RequestParam(value = "identityNumber",required = false)String identity,
                             @RequestParam(value = "namePatient",required = false)String name,
                             @RequestParam(value = "DOB",required = false) String dob,
                             @RequestParam(value = "address",required = false)String address,
                             @RequestParam(value = "phone",required = false)String phone,
                             Patient patient, Model model){
        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient",Patient[].class));
        for(Patient patient1 : patients){
            if(id.equals(patient1.getID_Patient())){
                patient.setID_Patient(id);
                patient.setIdentityNumber(identity);
                patient.setNamePatient(name);
                patient.setDOB(dob);
                patient.setAddress(address);
                patient.setPhone(phone);
                model.addAttribute("warningAdd", "Patient is already exist!");
                model.addAttribute("patients",patient);
                return "formAddPatient";
            }
        }
        patient.setID_Patient(id);
        patient.setIdentityNumber(identity);
        patient.setNamePatient(name);
        patient.setDOB(dob);
        patient.setAddress(address);
        patient.setPhone(phone);
        log.info("New"+patient);
        rest.postForObject("http://localhost:8081/patient",patient,Patient.class);
        return "redirect:/patient";
    }
    @PostMapping("/{id}")
    public String updatePatient(@PathVariable(value = "id",required = false) String id,
                             @RequestParam(value = "identityNumber",required = false)String identity,
                             @RequestParam(value = "namePatient",required = false)String name,
                             @RequestParam(value = "DOB",required = false) String dob,
                             @RequestParam(value = "address",required = false)String address,
                             @RequestParam(value = "phone",required = false)String phone,
                             Patient patient){
        patient.setID_Patient(id);
        patient.setIdentityNumber(identity);
        patient.setNamePatient(name);
        patient.setDOB(dob);
        patient.setAddress(address);
        patient.setPhone(phone);
        log.info("New"+patient);
        rest.postForObject("http://localhost:8081/patient",patient,Patient.class);
        return "redirect:/patient";
    }
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable(value = "id",required = false) String id,Model model){
        try{
            rest.delete("http://localhost:8081/patient/delete/{id}",id);
        }catch (Exception e){
            model.addAttribute("warning","Cannot delete! This patient is already in examination record");
        }
        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient",Patient[].class));
        model.addAttribute("patients",patients);
        return "informationPatient";
    }
    @GetMapping("/edit/{id}")
    public String editIngredient(@PathVariable(value = "id",required = false)String id,Model model){
        Patient patient = rest.getForObject("http://localhost:8081/patient/{id}",Patient.class,id);
        model.addAttribute("patient",patient);
        return "formUpdatePatient";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String id,Model model){
        Patient patient = rest.getForObject("http://localhost:8081/patient/{id}", Patient.class,id);
        model.addAttribute("patients",patient);
        return "informationPatient";
    }
}
