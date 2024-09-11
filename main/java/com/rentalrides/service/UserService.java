package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.User;

public interface UserService {
	
	  User saveUser(User user) ;
	    User getUserById(Long userId);
	    User getUserByEmail(String email);
	     List<User> getAllUsers() ;
	    void updateUser(User user);
	    void deleteUser(Long userId);
	    
	    boolean loginUser(String email, String password);
		static String deleteUser(String id) {
			// TODO Auto-generated method stub
			return deleteUser(id);
		}

}
