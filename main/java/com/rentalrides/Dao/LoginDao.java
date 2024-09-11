package com.rentalrides.Dao;

import com.rentalrides.entity.Login;

public interface LoginDao {
	
	void saveLogin(Login login);
	Login getLoginByEmail(String email);

}
