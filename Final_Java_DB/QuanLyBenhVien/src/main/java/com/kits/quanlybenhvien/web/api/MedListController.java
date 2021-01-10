package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.*;

import com.kits.quanlybenhvien.repository.MedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/medlist", produces = "application/json")
@CrossOrigin(value = "*")
public class MedListController {
    private MedListRepository medlistRepository;
    @Autowired
    public MedListController(MedListRepository medlistRepository){
        this.medlistRepository = medlistRepository;
    }
    @GetMapping
    public Iterable<MedList> getAllMedList(){
        return medlistRepository.findAll();
    }
    @GetMapping("/search/{keyword}")
    public List<MedList> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<MedList> lists = medlistRepository.findAll();
        List<MedList> result = new ArrayList<>();
        for(MedList ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }
    @GetMapping("{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}")
    public MedList MedListById(@PathVariable(value = "id", required = false) String id,
                               @PathVariable(value = "id2", required = false) Integer id2,
                               @PathVariable(value = "id3", required = false) Integer id3,
                               @PathVariable(value = "id4", required = false) String id4,
                               @PathVariable(value = "id5", required = false) String id5,
                               @PathVariable(value = "id6", required = false) String id6,
                               @PathVariable(value = "id7", required = false) String id7,
                               @PathVariable(value = "id8", required = false) String id8){
        MedListKey medlistKey = new MedListKey();
        medlistKey.setNameMed(id);
        medlistKey.setID_Treatment(id2);
        medlistKey.setIDExamination(id3);
        medlistKey.setNameDisease(id4);
        medlistKey.setID_DoctorExamination(id5);
        medlistKey.setID_DoctorCure(id6);
        medlistKey.setIDPatient(id7);
        medlistKey.setID_Nurse(id8);

        Optional<MedList> optionalMedList = medlistRepository.findById(medlistKey);
        if(optionalMedList.isPresent()){
            return optionalMedList.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}")
    public void delete(@PathVariable(value = "id", required = false) String id,
                       @PathVariable(value = "id2", required = false) Integer id2,
                       @PathVariable(value = "id3", required = false) Integer id3,
                       @PathVariable(value = "id4", required = false) String id4,
                       @PathVariable(value = "id5", required = false) String id5,
                       @PathVariable(value = "id6", required = false) String id6,
                       @PathVariable(value = "id7", required = false) String id7,
                       @PathVariable(value = "id8", required = false) String id8,MedListKey medlistKey){
        medlistKey.setNameMed(id);
        medlistKey.setID_Treatment(id2);
        medlistKey.setIDExamination(id3);
        medlistKey.setNameDisease(id4);
        medlistKey.setID_DoctorExamination(id5);
        medlistKey.setID_DoctorCure(id6);
        medlistKey.setIDPatient(id7);
        medlistKey.setID_Nurse(id8);
        try {
            medlistRepository.deleteById(medlistKey);
        }catch (EmptyResultDataAccessException e){}
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MedList saveMedList(@RequestBody MedList  medlist){
        return medlistRepository.save( medlist);
    }
}
