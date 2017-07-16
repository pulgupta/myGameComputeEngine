package com.klgs.gameEngine.dao;

import org.springframework.stereotype.Component;

import com.klgs.gameEngine.model.User;

@Component
public interface UserDAO {
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUser(String emailId);
}
