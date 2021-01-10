package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@IdClass(ServiceListKey.class)
public class ServiceList extends ServiceListKey {
    @Id
    @Column(name = "Name_Service")
    String nameService;
    @Id
    @Column(name = "ID_Treatment")
    Integer ID_Treatment;
    @Id
    @Column(name = "ID_Examination")
    Integer IDExamination;
    @Id
    @Column(name = "Name_Disease")
    String nameDisease;
    @Id
    @Column(name = "ID_DoctorExamination")
    String ID_DoctorExamination;
    @Id
    @Column(name = "ID_DoctorCure")
    String ID_DoctorCure;
    @Id
    @Column(name = "ID_Patient")
    String IDPatient;
    @Id
    @Column(name = "ID_Nurse")
    String ID_Nurse;
}
