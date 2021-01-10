package com.kits.quanlybenhvien.entity;
import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.persistence.Column;

import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Table(name = "doctor")
public class Doctor {
    @Id
    private String ID_Doctor;
    @NotNull
    private String identityNumber;
    @NotNull
    private String nameDoctor;
    @NotNull
    private String DOB;
    @NotNull
    private String address;
    @NotNull
    private int exp;
    @NotNull
    private String diploma;
    @NotNull
    private String field;
    @NotNull
    private String position;
}
