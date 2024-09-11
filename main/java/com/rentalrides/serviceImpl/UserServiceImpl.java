package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.UserDaoImpl;
import com.rentalrides.entity.User;
import com.rentalrides.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

	

	@Override
	public User getUserById(Long userId) {
        return userDao.getUserById(userId);

	}

	@Override
	public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);

	}

	public List<User> getAllUsers() {
        return userDao.getAllUsers();

	}

	@Override
	public void updateUser(User user) {
        userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
		
	}

	@Override
	public boolean loginUser(String email, String password) {
		   User user = userDao.getUserByEmail(email);
	        return user != null && user.getPassword().equals(password);
	    }

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		     return userDao.saveUser(user);

	}
	

}
