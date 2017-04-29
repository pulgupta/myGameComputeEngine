package com.klgs.rest.gameEngine.www;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.klgs.rest.gameEngine.www.model.Question;

@RestController
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
