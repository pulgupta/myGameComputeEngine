package com.klgs.rest.gameEngine.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.klgs.rest.gameEngine.www.model.User;
import com.klgs.rest.gameEngine.www.util.InMemoryStore;
import com.klgs.rest.gameEngine.www.util.UuidGenerator;

@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping(value="/user")
@RestController
public class UserRest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InMemoryStore store;
	
	// Creating a new User
	@RequestMapping(value="", method=RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		System.out.println("This is inside the post method of User" + user);
		user.setVoterId(UuidGenerator.generateUuid());
		store.addUser(user);
		return user;
	}
	
	// This method wil update the existing user
	@RequestMapping(value="/{userName}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable String userName, @RequestBody User updatedUser) {
		User user = store.getUser(userName);
		if(user==null)
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		
		//Mapping old user with new user
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		user.setDob(updatedUser.getDob());
		user.setGender(updatedUser.getGender());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userName}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String userName) {
		log.info("In get by user name call of user");
		User user = store.getUser(userName);
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			log.info(user.toString());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
