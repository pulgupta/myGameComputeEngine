package com.klgs.rest.gameEngine.DAO;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.klgs.rest.gameEngine.GameEngineWwwApplication;
import com.klgs.rest.gameEngine.dao.UserDAO;
import com.klgs.rest.gameEngine.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GameEngineWwwApplication.class })
public class UserDAOTests {
	
	@Autowired
	UserDAO userDao;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		String emailId = "pulgupta@gmail.com";
		user.setEmailId(emailId);
		userDao.createUser(user);
		
		//Test if the user was indeed saved
		User newUser = userDao.getUser(emailId);
		assertNotNull(newUser);
	}

}
