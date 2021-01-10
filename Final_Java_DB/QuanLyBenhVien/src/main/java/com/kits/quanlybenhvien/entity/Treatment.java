package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@IdClass(TreatmentKey.class)
public class Treatment extends TreatmentKey{
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

    private String atTime;
    private Boolean status;
}
