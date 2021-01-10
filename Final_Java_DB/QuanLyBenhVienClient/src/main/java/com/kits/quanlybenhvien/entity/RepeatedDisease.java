package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
public class RepeatedDisease  {
    private String IDPatient;
    private String nameDisease;
    private String repeatedTimes;
}
