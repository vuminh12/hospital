package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor(force = true)
public class Examination{
    private Integer IDExamination;
    private String ID_DoctorExamination;
    private String IDPatient;
    private String atTime;
}
