package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
@RequiredArgsConstructor
public class DiseaseSummary7Key implements Serializable {
    private String nameDisease;
    private String numPatients;
}
