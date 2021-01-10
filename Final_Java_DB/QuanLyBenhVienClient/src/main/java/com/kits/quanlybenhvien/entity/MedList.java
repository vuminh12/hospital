package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
public class MedList {
    private String nameMed;
    private Integer ID_Treatment;
    private Integer IDExamination;
    private String nameDisease;
    private String ID_DoctorExamination;
    private String ID_DoctorCure;
    private String IDPatient;
    private String ID_Nurse;
}
