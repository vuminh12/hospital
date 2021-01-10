package com.kits.quanlybenhvien.repository;

import com.kits.quanlybenhvien.entity.RepeatedDisease;
import com.kits.quanlybenhvien.entity.RepeatedDiseaseKey;
import org.springframework.data.repository.CrudRepository;

public interface RepeatedDiseaseRepository extends CrudRepository<RepeatedDisease, RepeatedDiseaseKey> {
}
