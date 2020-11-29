package com.codeflex.springboot.service;


import java.util.List;

import com.codeflex.springboot.model.Staff;

public interface StaffService {

    Staff findById(long id);

    Staff findByName(String name);

    void saveStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaffById(long id);

    List<Staff> findAllStaffs();

    void deleteAllStaffs();

    boolean isStaffExist(Staff staff);

}
