package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@IdClass(ExaminationKey.class)
public class Examination extends ExaminationKey{
    @Id
    @Column(name = "ID_Examination")
    Integer IDExamination;
    @Id
    @Column(name = "ID_Doctor_Examination")
    String ID_DoctorExamination;
    @Id
    @Column(name = " ID_Patient")
    String IDPatient;
    private String atTime;
}
