package com.brodyway.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brodyway.Springproject.Model.User;
import com.brodyway.Springproject.Repositry.UserRepositry;
import com.brodyway.Springproject.Service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepositry userRepo;

	@Override
	public void signup(User user) {
		userRepo.save(user);

	}

	@Override
	public User login(String un, String psw) {

		return userRepo.findByUsernameAndPassword(un, psw);
		

	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public void updateUser(User ur) {
		userRepo.save(ur);

	}

	@Override
	public User getUserById(int id) {

		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	

	
}

	

	

	
	

