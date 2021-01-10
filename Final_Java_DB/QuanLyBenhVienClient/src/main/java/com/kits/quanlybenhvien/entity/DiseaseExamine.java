package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
public class DiseaseExamine  {
    private Integer IDExamination;
    private String ID_DoctorExamination;
    private String IDPatient;
    private String nameDisease;
}
