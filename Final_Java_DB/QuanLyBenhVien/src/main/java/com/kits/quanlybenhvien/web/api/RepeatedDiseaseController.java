package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.RepeatedDisease;

import com.kits.quanlybenhvien.repository.RepeatedDiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/repeateddisease", produces = "application/json")
@CrossOrigin(value = "*")
public class RepeatedDiseaseController {
    private RepeatedDiseaseRepository repeatedDiseaseRepository;
    @Autowired
    public RepeatedDiseaseController(RepeatedDiseaseRepository repeatedDiseaseRepository){
        this.repeatedDiseaseRepository = repeatedDiseaseRepository;
    }
    @GetMapping
    public Iterable<RepeatedDisease> getAllRepeatedDisease(){
        return repeatedDiseaseRepository.findAll();
    }

    @GetMapping("/search/{keyword}")
    public List<RepeatedDisease> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<RepeatedDisease> lists = repeatedDiseaseRepository.findAll();
        List<RepeatedDisease> result = new ArrayList<>();
        for(RepeatedDisease ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }



    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RepeatedDisease saveRepeatedDisease(@RequestBody RepeatedDisease repeatedDisease){
        return repeatedDiseaseRepository.save(repeatedDisease);
    }

}
