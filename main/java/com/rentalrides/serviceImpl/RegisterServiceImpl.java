package com.rentalrides.serviceImpl;

import com.rentalrides.DaoImpl.RegisterDaoImpl;
import com.rentalrides.entity.Register;
import com.rentalrides.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{
	
    private RegisterDaoImpl registerdao=new RegisterDaoImpl();


	@Override
	public void saveRegister(Register register) {
        registerdao.saveRegister(register);

		
	}

	@Override
	public Register getRegisterByEmail(String email) {
        return registerdao.getRegisterByEmail(email);

	}

}
