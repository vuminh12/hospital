package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.Examination;
import com.kits.quanlybenhvien.entity.ExaminationKey;
import com.kits.quanlybenhvien.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/examination", produces = "application/json")
@CrossOrigin(value = "*")
public class ExaminationController {
    private ExaminationRepository examinationRepository;
    @Autowired
    public ExaminationController(ExaminationRepository examinationRepository){
        this.examinationRepository = examinationRepository;
    }
    @GetMapping
    public Iterable<Examination> getAllExamination(){
        return examinationRepository.findAll();
    }
    @GetMapping("/search/{keyword}")
    public List<Examination> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<Examination> lists = examinationRepository.findAll();
        List<Examination> result = new ArrayList<>();
        for(Examination ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }

    @DeleteMapping("/delete/{id}/{id2}/{id3}")
    public void delete(@PathVariable(value = "id", required = false) Integer id,
                       @PathVariable(value = "id2", required = false) String id2,
                       @PathVariable(value = "id3", required = false) String id3){
        ExaminationKey examinationKey = new ExaminationKey();
        examinationKey.setIDExamination(id);
        examinationKey.setID_DoctorExamination(id2);
        examinationKey.setIDPatient(id3);
        try {
            examinationRepository.deleteById(examinationKey);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Examination saveExamination(@RequestBody Examination examination){
        return examinationRepository.save(examination);
    }
    @GetMapping("/edit/{id}/{id2}/{id3}")
    public Optional<Examination> updateExamination (@PathVariable(value = "id", required = false) Integer id,
                                                    @PathVariable(value = "id2", required = false) String id2,
                                                    @PathVariable(value = "id3", required = false) String id3){
        ExaminationKey examinationKey = new ExaminationKey();
        examinationKey.setIDExamination(id);
        examinationKey.setID_DoctorExamination(id2);
        examinationKey.setIDPatient(id3);
        Optional<Examination> examination = examinationRepository.findById(examinationKey);
        return examination;
    }

}
