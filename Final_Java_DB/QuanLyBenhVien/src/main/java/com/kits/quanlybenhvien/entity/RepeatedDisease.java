package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@RequiredArgsConstructor
@IdClass(RepeatedDiseaseKey.class)
public class RepeatedDisease  {
    @Id
    @Column(name = "ID_Patient")
    private String IDPatient;
    @Id
    @Column(name = "Name_Disease")
    private String nameDisease;
    @Id
    @Column(name = "repeated_Times")
    private String repeatedTimes;
}
