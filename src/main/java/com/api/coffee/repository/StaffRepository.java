package com.api.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.coffee.models.Staff;

public interface StaffRepository extends JpaRepository <Staff, Long>{
    
}
