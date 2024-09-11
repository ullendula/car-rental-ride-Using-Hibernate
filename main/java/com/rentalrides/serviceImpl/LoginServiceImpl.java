package com.rentalrides.serviceImpl;

import com.rentalrides.Dao.LoginDao;
import com.rentalrides.DaoImpl.LoginDaoImpl;
import com.rentalrides.entity.Login;
import com.rentalrides.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	 private LoginDao loginDao = new LoginDaoImpl();

	    @Override
	    public void saveLogin(Login login) {
	        loginDao.saveLogin(login);
	    }

	    @Override
	    public Login getLoginByEmail(String email) {
	        return loginDao.getLoginByEmail(email);
	    }

		@Override
		public boolean loginAdmin(Login loginAdmin) {
			return false;
		}

		@Override
	    public boolean loginUser(Login login) {
	        // Logic to validate login credentials
	        // This can involve checking the database for a matching record
	        // Example: return true if credentials are valid, else false

	        // For demonstration, let's assume it always returns true
	        return true;
	    }
		
}
