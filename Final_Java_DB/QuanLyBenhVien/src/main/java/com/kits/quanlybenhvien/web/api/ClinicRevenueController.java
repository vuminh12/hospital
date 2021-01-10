package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.ClinicRevenue;
import com.kits.quanlybenhvien.repository.ClinicRevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/homePage", produces = "application/json")
@CrossOrigin(value = "*")
public class ClinicRevenueController {
    private ClinicRevenueRepository clinicRevenueRepository;
    @Autowired
    public ClinicRevenueController(ClinicRevenueRepository clinicRevenueRepository){
        this.clinicRevenueRepository = clinicRevenueRepository;
    }
    @GetMapping
    public Iterable<ClinicRevenue> getAllClinicRevenue(){
        return clinicRevenueRepository.findAll();
    }
}
