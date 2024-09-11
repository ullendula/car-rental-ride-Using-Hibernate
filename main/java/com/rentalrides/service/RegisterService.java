package com.rentalrides.service;

import com.rentalrides.entity.Register;

public interface RegisterService {
	
	void saveRegister(Register register);
    Register getRegisterByEmail(String email);

}
