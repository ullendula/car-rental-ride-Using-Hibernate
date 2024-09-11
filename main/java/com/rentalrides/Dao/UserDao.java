package com.rentalrides.Dao;

import java.util.List;

import com.rentalrides.entity.User;

public interface UserDao {
	
	 User saveUser(User user);
	    User getUserById(Long userId);
	    User getUserByEmail(String email);
	    List<User> getAllUsers();
	    void updateUser(User user);
	    void deleteUser(Long userId);


}


