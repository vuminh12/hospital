package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.DiseaseExamine;
import com.kits.quanlybenhvien.entity.DiseaseExamineKey;
import com.kits.quanlybenhvien.entity.Examination;
import com.kits.quanlybenhvien.entity.ExaminationKey;
import com.kits.quanlybenhvien.repository.DiseaseExamineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/diseaseExamine", produces = "application/json")
@CrossOrigin(value = "*")
public class DiseaseExamineController {
    private DiseaseExamineRepository diseaseExamineRepository;
    @Autowired
    public DiseaseExamineController(DiseaseExamineRepository diseaseExamineRepository){
        this.diseaseExamineRepository = diseaseExamineRepository;
    }
    @GetMapping
    public Iterable<DiseaseExamine> getAllDiseaseExamine(){
        return diseaseExamineRepository.findAll();
    }

    @GetMapping("/search/{keyword}")
    public List<DiseaseExamine> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<DiseaseExamine> lists = diseaseExamineRepository.findAll();
        List<DiseaseExamine> result = new ArrayList<>();
        for(DiseaseExamine ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }

    @GetMapping("/{id}/{id2}/{id3}/{id4}")
    public DiseaseExamine DiseaseExamineById(@PathVariable(value = "id", required = false) Integer id,
                                             @PathVariable(value = "id2", required = false) String id2,
                                             @PathVariable(value = "id3", required = false) String id3,
                                             @PathVariable(value = "id4", required = false) String id4){
        DiseaseExamineKey diseaseExamineKey = new DiseaseExamineKey();
        diseaseExamineKey.setIDExamination(id);
        diseaseExamineKey.setID_DoctorExamination(id2);
        diseaseExamineKey.setIDPatient(id3);
        diseaseExamineKey.setNameDisease(id4);
        Optional<DiseaseExamine> optionalDiseaseExamine = diseaseExamineRepository.findById(diseaseExamineKey);
        if(optionalDiseaseExamine.isPresent()){
            return optionalDiseaseExamine.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}/{id2}/{id3}/{id4}")
    public void delete(@PathVariable(value = "id", required = false) Integer id,
                       @PathVariable(value = "id2", required = false) String id2,
                       @PathVariable(value = "id3", required = false) String id3,
                       @PathVariable(value = "id4", required = false) String id4){
        DiseaseExamineKey diseaseExamineKey = new DiseaseExamineKey();
        diseaseExamineKey.setIDExamination(id);
        diseaseExamineKey.setID_DoctorExamination(id2);
        diseaseExamineKey.setIDPatient(id3);
        diseaseExamineKey.setNameDisease(id4);
        try {
            diseaseExamineRepository.deleteById(diseaseExamineKey);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DiseaseExamine saveDiseaseExamine(@RequestBody DiseaseExamine diseaseExamine){
        return diseaseExamineRepository.save(diseaseExamine);
    }
    @GetMapping("/edit/{id}/{id2}/{id3}/{id4}")
    public Optional<DiseaseExamine> updateDiseaseExamine (@PathVariable(value = "id", required = false) Integer id,
                                                          @PathVariable(value = "id2", required = false) String id2,
                                                          @PathVariable(value = "id3", required = false) String id3,
                                                          @PathVariable(value = "id4", required = false) String id4){
        DiseaseExamineKey diseaseExamineKey = new DiseaseExamineKey();
        diseaseExamineKey.setIDExamination(id);
        diseaseExamineKey.setID_DoctorExamination(id2);
        diseaseExamineKey.setIDPatient(id3);
        diseaseExamineKey.setNameDisease(id4);
        Optional<DiseaseExamine> diseaseExamine = diseaseExamineRepository.findById(diseaseExamineKey);
        return diseaseExamine;
    }
}
