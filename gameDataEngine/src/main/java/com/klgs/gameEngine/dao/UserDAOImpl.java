package com.klgs.gameEngine.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.klgs.gameEngine.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}
	
	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}
	
	//We will never delete the data. We will just make the user inactive
	@Override
	public void deleteUser(User user) {
		entityManager.merge(user); 
	}
	
	@Override
	public User getUser(String emailId) {
		User user = entityManager.find(User.class, emailId);
		return user;
	}

}
