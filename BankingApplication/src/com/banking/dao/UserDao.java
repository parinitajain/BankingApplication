package com.banking.dao;

import com.banking.dto.User;

public interface UserDao {
	
	public int addUser(User user);
	
	public User getUserById(int id);
	
	public int updateUserBalance(User user);
	

}
