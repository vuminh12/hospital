package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
@RequiredArgsConstructor
public class RepeatedDiseaseKey  implements Serializable {
    private String IDPatient;
    private String nameDisease;
    private String repeatedTimes;
}
