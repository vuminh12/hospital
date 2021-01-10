package com.kits.quanlybenhvien.web.api;

import com.kits.quanlybenhvien.entity.Nurse;
import com.kits.quanlybenhvien.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/nurse", produces = "application/json")
@CrossOrigin(origins = "*")
public class NurseController {
    private NurseRepository nurseRepository;
    @Autowired
    public NurseController(NurseRepository nurseRepository){
        this.nurseRepository = nurseRepository;
    }
    @GetMapping
    public Iterable<Nurse> getAllNurse(){
        return nurseRepository.findAll();
    }
    @GetMapping("/{id}")
    public Nurse nurseById(@PathVariable(value = "id", required = false) String id){
        Optional<Nurse> optionalNurse = nurseRepository.findById(id);
        if(optionalNurse.isPresent()){
            return optionalNurse.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id", required = false) String ID_Nurse){
        try {
            nurseRepository.deleteById(ID_Nurse);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Nurse saveNurse(@RequestBody Nurse nurse){
        return nurseRepository.save(nurse);
    }
}
