package com.klgs.rest.gameEngine.www;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.klgs.rest.gameEngine.www.model.Question;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //When we are caling a REST API from another application
//running on a particular server and port we will have to specify that we want to allow 
//access to that another server application. For this we have added this CROS else we will get
//403 in our angular application
@RequestMapping(value="/question")
public class QuestionRest {

	@RequestMapping(value="", method=RequestMethod.POST)
	public Question saveQuestion(Question question) {
		System.out.println("This is inside the post method of Question" + question);
		return question;
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
