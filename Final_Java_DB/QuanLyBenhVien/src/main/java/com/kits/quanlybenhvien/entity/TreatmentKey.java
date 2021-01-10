package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

//@Embeddable
@Data
@RequiredArgsConstructor
public class TreatmentKey implements Serializable {
    Integer ID_Treatment;
    Integer IDExamination;
    String nameDisease;
    String ID_DoctorExamination;
    String ID_DoctorCure;
    String IDPatient;
    String ID_Nurse;

}
