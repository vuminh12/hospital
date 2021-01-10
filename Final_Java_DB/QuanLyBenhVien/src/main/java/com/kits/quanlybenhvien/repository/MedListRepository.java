package com.kits.quanlybenhvien.repository;


import com.kits.quanlybenhvien.entity.MedList;
import com.kits.quanlybenhvien.entity.MedListKey;
import org.springframework.data.repository.CrudRepository;

public interface MedListRepository extends CrudRepository<MedList, MedListKey> {
}
