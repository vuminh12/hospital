package com.kits.quanlybenhvien.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor

public class ClinicRevenue {
    @Id
    private float totalRevenue;
}
