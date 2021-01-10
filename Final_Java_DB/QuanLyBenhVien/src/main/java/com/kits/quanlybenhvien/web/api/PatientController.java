package com.kits.quanlybenhvien.web.api;

import com.kits.quanlybenhvien.entity.Patient;
import com.kits.quanlybenhvien.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/patient", produces = "application/json")
@CrossOrigin(value = "*")
public class PatientController {
    private PatientRepository patientRepository;
    @Autowired
    public PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Patient getById(@PathVariable(value = "id", required = false)String id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return  patient.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        try {
            patientRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}
