package com.kits.quanlybenhvien.web.api;

import com.kits.quanlybenhvien.entity.Doctor;
import com.kits.quanlybenhvien.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/doctor", produces = "application/json")
@CrossOrigin(origins = "*")
public class DoctorController {
    private DoctorRepository doctorRepository;
    @Autowired
    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }
    @GetMapping
    public Iterable<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Doctor doctorById(@PathVariable(value = "id", required = false) String id){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id", required = false) String ID_Doctor){
        try {
            doctorRepository.deleteById(ID_Doctor);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }
}
