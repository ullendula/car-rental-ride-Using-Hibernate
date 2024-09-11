package com.rentalrides.service;

import com.rentalrides.entity.Login;

public interface LoginService {
	
	void saveLogin(Login login);
    Login getLoginByEmail(String email);
	boolean loginAdmin(Login loginAdmin);
    boolean loginUser(Login login);

}
