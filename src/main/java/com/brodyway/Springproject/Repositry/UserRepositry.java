package com.brodyway.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodyway.Springproject.Model.User;

public interface UserRepositry extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String un, String psw); 
	
}
