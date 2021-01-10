package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(force = true)
public class Service {
    private String nameService;
    private float price;
}
