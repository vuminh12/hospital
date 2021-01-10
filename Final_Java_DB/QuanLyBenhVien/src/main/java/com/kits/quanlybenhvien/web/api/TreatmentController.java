package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.*;

import com.kits.quanlybenhvien.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/treatment", produces = "application/json")
@CrossOrigin(value = "*")
public class TreatmentController {
    private TreatmentRepository treatmentRepository;
    @Autowired
    public TreatmentController(TreatmentRepository treatmentRepository){
        this.treatmentRepository = treatmentRepository;
    }
    @GetMapping
    public Iterable<Treatment> getAllTreatment(){
        return treatmentRepository.findAll();
    }
    @GetMapping("/search/{keyword}")
    public List<Treatment> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<Treatment> lists = treatmentRepository.findAll();
        List<Treatment> result = new ArrayList<>();
        for(Treatment ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }
    @GetMapping("{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public Treatment TreatmentById(@PathVariable(value = "id", required = false) Integer id,
                                   @PathVariable(value = "id2", required = false) Integer id2,
                                   @PathVariable(value = "id3", required = false) String id3,
                                   @PathVariable(value = "id4", required = false) String id4,
                                   @PathVariable(value = "id5", required = false) String id5,
                                   @PathVariable(value = "id6", required = false) String id6,
                                   @PathVariable(value = "id7", required = false) String id7){
        TreatmentKey treatmentKey = new TreatmentKey();
        treatmentKey.setID_Treatment(id);
        treatmentKey.setIDExamination(id2);
        treatmentKey.setNameDisease(id3);
        treatmentKey.setID_DoctorExamination(id4);
        treatmentKey.setID_DoctorCure(id5);
        treatmentKey.setIDPatient(id6);
        treatmentKey.setID_Nurse(id7);

        Optional<Treatment> optionalTreatment = treatmentRepository.findById(treatmentKey);
        if(optionalTreatment.isPresent()){
            return optionalTreatment.get();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public void delete(@PathVariable(value = "id", required = false) Integer id,
                       @PathVariable(value = "id2", required = false) Integer id2,
                       @PathVariable(value = "id3", required = false) String id3,
                       @PathVariable(value = "id4", required = false) String id4,
                       @PathVariable(value = "id5", required = false) String id5,
                       @PathVariable(value = "id6", required = false) String id6,
                       @PathVariable(value = "id7", required = false) String id7){
        TreatmentKey treatmentKey = new TreatmentKey();
        treatmentKey.setID_Treatment(id);
        treatmentKey.setIDExamination(id2);
        treatmentKey.setNameDisease(id3);
        treatmentKey.setID_DoctorExamination(id4);
        treatmentKey.setID_DoctorCure(id5);
        treatmentKey.setIDPatient(id6);
        treatmentKey.setID_Nurse(id7);
        try {
            treatmentRepository.deleteById(treatmentKey);
        }catch (EmptyResultDataAccessException e){}
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Treatment saveTreatment(@RequestBody Treatment treatment){
        return treatmentRepository.save(treatment);
    }

    @GetMapping("/edit/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}")
    public Optional<Treatment> updateTreatment (@PathVariable(value = "id", required = false) Integer id,
                                                @PathVariable(value = "id2", required = false) Integer id2,
                                                @PathVariable(value = "id3", required = false) String id3,
                                                @PathVariable(value = "id4", required = false) String id4,
                                                @PathVariable(value = "id5", required = false) String id5,
                                                @PathVariable(value = "id6", required = false) String id6,
                                                @PathVariable(value = "id7", required = false) String id7){
        TreatmentKey treatmentKey = new TreatmentKey();
        treatmentKey.setID_Treatment(id);
        treatmentKey.setIDExamination(id2);
        treatmentKey.setNameDisease(id3);
        treatmentKey.setID_DoctorExamination(id4);
        treatmentKey.setID_DoctorCure(id5);
        treatmentKey.setIDPatient(id6);
        treatmentKey.setID_Nurse(id7);
        Optional<Treatment> treatment = treatmentRepository.findById(treatmentKey);
        return treatment;
    }
}
