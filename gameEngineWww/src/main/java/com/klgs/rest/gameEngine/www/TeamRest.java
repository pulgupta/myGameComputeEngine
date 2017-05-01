package com.klgs.rest.gameEngine.www;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.klgs.rest.gameEngine.www.model.Team;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/team")
public class TeamRest {

	@RequestMapping(value="", method=RequestMethod.POST)
	public Team saveQuestion(@RequestBody Team team) {
		System.out.println("This is inside the post method of Question" + team);
		return team;
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
