package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import com.sun.javafx.beans.IDProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Patient {
    @Id
    private String ID_Patient;
    @NotNull
    private String identityNumber;
    @NotNull
    private String namePatient;
    @NotNull
    private String DOB;
    @NotNull
    private String address;
    @NotNull
    private String phone;
}
