package com.api.coffee.service;

import java.util.List;

import com.api.coffee.models.Staff;

public interface StaffService {
    List<Staff> getAllStaffs();

    Staff createStaff(Staff Staff);

    Staff updateStaff(Long id, Staff Staff);

    String deleteStaffById(Long id);

    Staff getStaffById(Long StaffId);
}
