package com.kits.quanlybenhvien.repository;


import com.kits.quanlybenhvien.entity.Treatment;
import com.kits.quanlybenhvien.entity.TreatmentKey;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment, TreatmentKey> {
}
