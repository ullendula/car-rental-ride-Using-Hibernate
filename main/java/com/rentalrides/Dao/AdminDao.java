package com.rentalrides.Dao;

import java.util.List;

import com.rentalrides.entity.Admin;

public interface AdminDao {
	
	void saveAdmin(Admin admin);
    Admin getAdminById(Long adminId);
    Admin getAdminByEmail(String email);
    List<Admin> getAllAdmins();
    void updateAdmin(Admin admin);
    void deleteAdmin(Long adminId);

}
