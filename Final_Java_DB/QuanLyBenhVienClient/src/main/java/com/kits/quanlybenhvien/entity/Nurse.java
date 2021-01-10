package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Data

@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Nurse {
    private String ID_Nurse;
    private String identityNumber;
    private String nameNurse;
    private String DOB;
    private String address;
    private int exp;
    private String diploma;
    private String phone;
}
