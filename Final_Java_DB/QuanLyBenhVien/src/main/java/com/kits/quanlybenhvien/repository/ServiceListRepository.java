package com.kits.quanlybenhvien.repository;



import com.kits.quanlybenhvien.entity.ServiceList;
import com.kits.quanlybenhvien.entity.ServiceListKey;
import org.springframework.data.repository.CrudRepository;

public interface ServiceListRepository extends CrudRepository<ServiceList, ServiceListKey> {
}
