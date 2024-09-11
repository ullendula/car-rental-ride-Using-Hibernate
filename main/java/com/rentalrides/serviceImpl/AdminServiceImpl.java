package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.AdminDaoImpl;
import com.rentalrides.entity.Admin;
import com.rentalrides.exception.AdminException;
import com.rentalrides.service.AdminService;

public class AdminServiceImpl  implements AdminService{

    private AdminDaoImpl adminDao = new AdminDaoImpl();

	
    @Override
    public void saveAdmin(Admin admin) {
        adminDao.saveAdmin(admin);
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminDao.getAdminById(adminId);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminDao.getAdminByEmail(email);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        adminDao.deleteAdmin(adminId);
    }

  
    @Override
    public boolean authenticate(String username, String password) throws AdminException {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return true;
        } else {
            throw new AdminException("Invalid Admin Credentials!");
        }
}}
