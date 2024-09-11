package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.Admin;
import com.rentalrides.exception.AdminException;

public interface AdminService {
	  void saveAdmin(Admin admin);
	    Admin getAdminById(Long adminId);
	    Admin getAdminByEmail(String email);
	    List<Admin> getAllAdmins();
	    void updateAdmin(Admin admin);
	    void deleteAdmin(Long adminId);
	    boolean authenticate(String username, String password) throws AdminException;

	    String ADMIN_USERNAME = "Admin";
	    String ADMIN_PASSWORD = "Admin@123";

}
