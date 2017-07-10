package com.klgs.rest.gameEngine.dao;

import org.springframework.stereotype.Component;

import com.klgs.rest.gameEngine.model.User;

@Component
public interface UserDAO {
	public void createUser(User user);
	public void updateUser();
	public void deleteUser();
	public User getUser(String emailId);
}
