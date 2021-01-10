package com.kits.quanlybenhvien.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class Patient {
    private String ID_Patient;
    private String identityNumber;
    private String namePatient;
    private String DOB;
    private String address;
    private String phone;
}
