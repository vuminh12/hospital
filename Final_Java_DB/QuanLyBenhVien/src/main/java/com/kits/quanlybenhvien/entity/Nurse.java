package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Nurse {
    @Id
    private String ID_Nurse;
    @NotNull
    private String identityNumber;
    @NotNull
    private String nameNurse;
    @NotNull
    private String DOB;
    @NotNull
    private String address;
    @NotNull
    private int exp;
    @NotNull
    private String diploma;
    @NotNull
    private String phone;
}
