package com.kits.quanlybenhvien.web.api;

import com.kits.quanlybenhvien.entity.Service;
import com.kits.quanlybenhvien.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/service", produces = "application/json")
@CrossOrigin(origins = "*")
public class ServiceController {
    private ServiceRepository serviceRepository;
    @Autowired
    public ServiceController(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }
    @GetMapping
    public Iterable<Service> getAllMed(){
        return serviceRepository.findAll();
    }
    @GetMapping("/{nameService}")
    public Service serviceById(@PathVariable(value = "nameService",required = false) String nameService){
        Optional<Service> optionalService = serviceRepository.findById(nameService);
        if(optionalService.isPresent()){
            return optionalService.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{nameService}")
    public void delete(@PathVariable(value = "nameService",required = false) String nameService){
        try {
            serviceRepository.deleteById(nameService);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Service postService(@RequestBody Service service){
        return serviceRepository.save(service);
    }
}