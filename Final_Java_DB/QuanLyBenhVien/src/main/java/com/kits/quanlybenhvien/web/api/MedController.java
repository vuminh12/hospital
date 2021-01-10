package com.kits.quanlybenhvien.web.api;

import com.kits.quanlybenhvien.entity.Med;
import com.kits.quanlybenhvien.repository.MedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/med", produces = "application/json")
@CrossOrigin(origins = "*")
public class MedController {
    private MedRepository medRepository;
    @Autowired
    public MedController(MedRepository medRepository){
        this.medRepository = medRepository;
    }
    @GetMapping
    public Iterable<Med> getAllMed(){
        return medRepository.findAll();
    }
    @GetMapping("/{nameMed}")
    public Med medById(@PathVariable(value = "nameMed",required = false) String nameMed){
        Optional<Med> optionalMed = medRepository.findById(nameMed);
        if(optionalMed.isPresent()){
            return optionalMed.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{nameMed}")
    public void delete(@PathVariable(value = "nameMed",required = false) String nameMed){
        try {
            medRepository.deleteById(nameMed);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Med postMed(@RequestBody Med med){
        return medRepository.save(med);
    }
}
