package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@RequiredArgsConstructor
@IdClass(DiseaseExamineKey.class)
public class DiseaseExamine extends DiseaseExamineKey {
    @Id
    @Column(name = "ID_Examination")
    Integer IDExamination;
    @Id
    @Column(name = "ID_Doctor_Examination")
    String ID_DoctorExamination;
    @Id
    @Column(name = "ID_Patient")
    String IDPatient;
    @Id
    @Column(name = "Name_Disease")
    String nameDisease;
}
