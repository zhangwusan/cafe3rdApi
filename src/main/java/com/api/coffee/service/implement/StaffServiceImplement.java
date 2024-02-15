package com.api.coffee.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.coffee.models.Staff;
import com.api.coffee.repository.StaffRepository;
import com.api.coffee.service.StaffService;

import lombok.NonNull;

@Component
public class StaffServiceImplement implements StaffService {
    @Autowired
    private StaffRepository StaffRepository;

    @Override
    public List<Staff> getAllStaffs() {
        return StaffRepository.findAll();
    }

    @Override
    public Staff createStaff(@NonNull Staff Staff) {
        return StaffRepository.save(Staff);
    }

    @Override
    public Staff updateStaff(@NonNull Long id, Staff Staff) {
        Staff StaffExist = StaffRepository.findById(id).get();
        StaffExist.setFirstName(Staff.getFirstName());
        StaffExist.setLastName(Staff.getLastName());
        StaffExist.setEmail(Staff.getEmail());
        StaffExist.setPhone(Staff.getPhone());
        StaffExist.setAddress(Staff.getAddress());
        StaffExist.setGender(Staff.getGender());
        StaffExist.setPassword(Staff.getPassword());
        StaffExist.setRole(Staff.getRole());
        return StaffRepository.save(StaffExist);
    }


    @Override
    public String deleteStaffById(@NonNull Long id) {
        StaffRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public Staff getStaffById(@NonNull Long StaffId) {
        return StaffRepository.findById(StaffId).orElse(null);
    }
}
