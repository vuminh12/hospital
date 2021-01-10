package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//@Embeddable
@Data
@RequiredArgsConstructor
public class ExaminationKey implements Serializable {
    Integer IDExamination;
    String ID_DoctorExamination;
    String IDPatient;


}
