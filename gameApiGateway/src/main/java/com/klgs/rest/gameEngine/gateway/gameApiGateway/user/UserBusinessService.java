package com.klgs.rest.gameEngine.gateway.gameApiGateway.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/userBusinessService")
public class UserBusinessService {

	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/{emailId}")
	public HttpStatus getUserAndEnrich(@PathVariable String emailId) {
		ResponseEntity<User> re = restTemplate.getForEntity("http://localhost:8282/user?email=" + emailId, User.class );
		return re.getStatusCode();
	}
}
