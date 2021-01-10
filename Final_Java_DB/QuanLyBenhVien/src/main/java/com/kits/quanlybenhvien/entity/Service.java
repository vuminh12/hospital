package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    private String nameService;


    @NotNull
    private float price;
}
