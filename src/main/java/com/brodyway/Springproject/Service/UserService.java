package com.brodyway.Springproject.Service;

import java.util.List;

import com.brodyway.Springproject.Model.User;

public interface UserService {
    void signup(User user);  
	User login(String un, String psw);

	void deleteUser(int id);

	void updateUser(User ur);

	User getUserById(int id);

	List<User> getAllUsers();
	
	
}
