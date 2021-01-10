package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.*;

import com.kits.quanlybenhvien.repository.ServiceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/servicelist", produces = "application/json")
@CrossOrigin(value = "*")
public class ServiceListController {
    private ServiceListRepository servicelistRepository;
    @Autowired
    public ServiceListController(ServiceListRepository servicelistRepository){
        this.servicelistRepository = servicelistRepository;
    }
    @GetMapping
    public Iterable<ServiceList> getAllServiceList(){
        return servicelistRepository.findAll();
    }

    @GetMapping("/search/{keyword}")
    public List<ServiceList> searchByKeyWord(@PathVariable(value = "keyword",required = false) String keyword){
        Iterable<ServiceList> lists = servicelistRepository.findAll();
        List<ServiceList> result = new ArrayList<>();
        for(ServiceList ex : lists){
            if(ex.getIDPatient().contains(keyword.toUpperCase())||ex.getIDPatient().contains(keyword.toLowerCase())){
                result.add(ex);
            }
        }
        return result;
    }
    @GetMapping("{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}")
    public ServiceList ServiceListById(@PathVariable(value = "id", required = false) String id,
                                       @PathVariable(value = "id2", required = false) Integer id2,
                                       @PathVariable(value = "id3", required = false) Integer id3,
                                       @PathVariable(value = "id4", required = false) String id4,
                                       @PathVariable(value = "id5", required = false) String id5,
                                       @PathVariable(value = "id6", required = false) String id6,
                                       @PathVariable(value = "id7", required = false) String id7,
                                       @PathVariable(value = "id8", required = false) String id8){
        ServiceListKey servicelistKey = new ServiceListKey();
        servicelistKey.setNameService(id);
        servicelistKey.setID_Treatment(id2);
        servicelistKey.setIDExamination(id3);
        servicelistKey.setNameDisease(id4);
        servicelistKey.setID_DoctorExamination(id5);
        servicelistKey.setID_DoctorCure(id6);
        servicelistKey.setIDPatient(id7);
        servicelistKey.setID_Nurse(id8);

        Optional<ServiceList> optionalServiceList = servicelistRepository.findById(servicelistKey);
        if(optionalServiceList.isPresent()){
            return optionalServiceList.get();
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
                       @PathVariable(value = "id8", required = false) String id8){
        ServiceListKey servicelistKey = new ServiceListKey();
        servicelistKey.setNameService(id);
        servicelistKey.setID_Treatment(id2);
        servicelistKey.setIDExamination(id3);
        servicelistKey.setNameDisease(id4);
        servicelistKey.setID_DoctorExamination(id5);
        servicelistKey.setID_DoctorCure(id6);
        servicelistKey.setIDPatient(id7);
        servicelistKey.setID_Nurse(id8);
        try {
            servicelistRepository.deleteById(servicelistKey);
        }catch (EmptyResultDataAccessException e){}
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceList saveServiceList(@RequestBody ServiceList servicelist){
        return servicelistRepository.save(servicelist);
    }
}
