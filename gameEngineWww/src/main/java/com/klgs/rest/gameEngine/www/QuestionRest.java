package com.klgs.rest.gameEngine.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klgs.rest.gameEngine.www.model.Question;
import com.klgs.rest.gameEngine.www.util.InMemoryStore;
import com.klgs.rest.gameEngine.www.util.UuidGenerator;

//When we are calling a REST API from another application
//running on a particular server and port we will have to specify that we want to allow 
//access to that another server application. For this we have added this CROS else we will get
//403 in our angular application
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping(value="/question")
@RestController
public class QuestionRest {

	@Autowired
	InMemoryStore store;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Question saveQuestion(@RequestBody Question question) {
		System.out.println("This is inside the post method of Question" + question);
		question.setQuestionId(UuidGenerator.generateUuid());
		store.addQuestion(question);
		return question;
	}
	
	@RequestMapping(value="/{questionId}", method=RequestMethod.GET)
	public ResponseEntity<Question> getQuestion(@PathVariable String questionId) {
		Question question = store.getQuestion(questionId);
		if(question == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
