package com.rentalrides.Dao;

import com.rentalrides.entity.Register;

public interface RegisterDao {
	
	void saveRegister(Register register);
    Register getRegisterByEmail(String email);


}
