package com.kits.quanlybenhvien.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor(force = true)
public class Med {
    private String nameMed;
    private float price;
    private String usedFor;

}
