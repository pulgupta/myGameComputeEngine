package com.klgs.gameEngine.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klgs.gameEngine.dao.UserDAO;
import com.klgs.gameEngine.model.User;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8282"})
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
	
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<User> getUser(@RequestParam String email) {
		log.info("we are calling dao to get the user" + email);
		User user = userDao.getUser(email);
		
		if (user == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		else
			return new ResponseEntity<>(user, HttpStatus.NO_CONTENT); 
	}

}
