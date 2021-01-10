package com.kits.quanlybenhvien.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force=true)
public class Doctor {
    private String ID_Doctor;
    private String identityNumber;
    private String nameDoctor;
    private String DOB;
    private String address;
    private int exp;
    private String diploma;
    private String field;
    private String position;
}
