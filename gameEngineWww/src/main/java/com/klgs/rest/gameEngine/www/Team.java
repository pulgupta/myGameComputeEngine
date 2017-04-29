package com.klgs.rest.gameEngine.www;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/team")
public class Team {
	
	@RequestMapping(value="")
	public String saveQuestion() {
		return ("team controller working");
	}
}
