package com.bway.springproject.dao;

import com.bway.springproject.model.User;

public interface UserDao {
	
	void signup(User u);
	
	boolean login(String un, String psw);

}
