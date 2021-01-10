package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.DiseaseSummary7;

import com.kits.quanlybenhvien.repository.DiseaseSummary7Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/diseasesummary7", produces = "application/json")
@CrossOrigin(value = "*")
public class DiseaseSummary7Controller {
    private DiseaseSummary7Repository diseaseSummary7Repository;
    @Autowired
    public DiseaseSummary7Controller(DiseaseSummary7Repository diseaseSummary7Repository){
        this.diseaseSummary7Repository = diseaseSummary7Repository;
    }
    @GetMapping
    public Iterable<DiseaseSummary7> getAllDiseaseSummary7(){
        return diseaseSummary7Repository.findAll();
    }

    @GetMapping("/search/{keyword}")
    public List<DiseaseSummary7> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<DiseaseSummary7> lists = diseaseSummary7Repository.findAll();
        List<DiseaseSummary7> result = new ArrayList<>();
        for(DiseaseSummary7 ex : lists){
            if(ex.getNameDisease().contains(keyword.toUpperCase())||ex.getNameDisease().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }



    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DiseaseSummary7 saveDiseaseSummary7(@RequestBody DiseaseSummary7 diseaseSummary7){
        return diseaseSummary7Repository.save(diseaseSummary7);
    }

}
