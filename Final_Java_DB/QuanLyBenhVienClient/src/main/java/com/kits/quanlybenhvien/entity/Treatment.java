package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(force = true)
public class Treatment {

    private Integer ID_Treatment;
    private Integer IDExamination;
    private String nameDisease;
    private String ID_DoctorExamination;
    private String ID_DoctorCure;
    private String IDPatient;
    private String ID_Nurse;

    private String atTime;
    private Boolean status;

}
