package com.klgs.rest.gameEngine.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klgs.rest.gameEngine.dao.UserDAO;
import com.klgs.rest.gameEngine.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/user")
public class UserRest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes="application/json")
	public void saveUser(@RequestBody User user) {
		log.debug("we are calling dao to save the user");
		userDao.createUser(user);
	}

}
