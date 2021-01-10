package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@RequiredArgsConstructor
@IdClass(DiseaseSummary7Key.class)
public class DiseaseSummary7 extends DiseaseSummary7Key {
    @Id
    @Column(name = "Name_Disease")
    private String nameDisease;
    @Id
    @Column(name = "Num_Patients")
    private String numPatients;
}
