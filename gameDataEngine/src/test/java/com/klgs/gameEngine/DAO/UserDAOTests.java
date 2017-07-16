package com.klgs.gameEngine.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.klgs.gameEngine.GameEngineWwwApplication;
import com.klgs.gameEngine.dao.UserDAO;
import com.klgs.gameEngine.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GameEngineWwwApplication.class })
public class UserDAOTests {
	
	@Autowired
	UserDAO userDao;
	
	@Test
	public void testCreateUserShouldExistsInDatabase() {
		User user = new User();
		String emailId = "pulgupta@gmail.com";
		user.setEmailId(emailId);
		user.setFirstName("Pulkit");
		userDao.createUser(user);
		
		//Test if the user was indeed saved
		User newUser = userDao.getUser(emailId);
		assertNotNull(newUser);
		assertTrue(newUser.getFirstName().equals("Pulkit"));
	}

}
