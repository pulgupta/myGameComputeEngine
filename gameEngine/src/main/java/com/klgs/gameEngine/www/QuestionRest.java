package com.klgs.gameEngine.www;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klgs.gameEngine.model.Question;
import com.klgs.gameEngine.util.InMemoryStore;
import com.klgs.gameEngine.util.UuidGenerator;

//When we are calling a REST API from another application
//running on a particular server and port we will have to specify that we want to allow 
//access to that another server application. For this we have added this CROS else we will get
//403 in our angular application
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping(value="/")
@RestController
public class QuestionRest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InMemoryStore store;
	
	@RequestMapping(value="question", method=RequestMethod.POST)
	public Question saveQuestion(@RequestBody Question question) {
		System.out.println("This is inside the post method of Question" + question);
		question.setQuestionId(UuidGenerator.generateUuid());
		store.addQuestion(question);
		return question;
	}
	
	@RequestMapping(value="question/{questionId}", method=RequestMethod.PUT)
	public ResponseEntity<Question> updateQuestion(@PathVariable String questionId, @RequestBody Question updatedQuestion) {
		Question question = store.getQuestion(questionId);
		if(question==null)
			return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
		//Mapping old question with new question
		question.setQuestion(updatedQuestion.getQuestion());
		question.setTags(updatedQuestion.getTags());
		
		question.setOptions(updatedQuestion.getOptions());
		
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	
	@RequestMapping(value="question/{questionId}", method=RequestMethod.GET)
	public ResponseEntity<Question> getQuestion(@PathVariable String questionId) {
		log.info("In get by Id call of question");
		Question question = store.getQuestion(questionId);
		if(question == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			log.info(question.toString());
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		}
	}
	
	//URL -> /vote/{questionId}?option={option}
	@RequestMapping(value="vote/{questionId}", method=RequestMethod.PUT) 
	public ResponseEntity<HttpStatus> updateVote(@PathVariable String questionId, @RequestParam String option) {
		if(store.getQuestion(questionId)==null)
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		//Question question = store.getQuestion(questionId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
