package com.kits.quanlybenhvien.repository;

import com.kits.quanlybenhvien.entity.Examination;
import com.kits.quanlybenhvien.entity.ExaminationKey;
import org.springframework.data.repository.CrudRepository;

public interface ExaminationRepository extends CrudRepository<Examination, ExaminationKey> {
    //List<Examination> findByIdIDExaminationAndID_DoctorExaminationAndIDPatient(int IDExamination,String ID_DoctorExamination,String IDPatient);

}
