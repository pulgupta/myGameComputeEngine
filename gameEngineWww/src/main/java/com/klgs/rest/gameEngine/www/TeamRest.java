package com.klgs.rest.gameEngine.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klgs.rest.gameEngine.www.model.Team;
import com.klgs.rest.gameEngine.www.util.InMemoryStore;
import com.klgs.rest.gameEngine.www.util.UuidGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/team")
public class TeamRest {

	@Autowired
	InMemoryStore store;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Team saveTeam(@RequestBody Team team) {
		System.out.println("This is inside the post method of Team" + team);
		String teamId = UuidGenerator.generateUuid();
		team.setTeamId(teamId);
		store.addTeam(team);
		return team;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Team> getTeam(@PathVariable String teamId) {
		Team team = store.getTeam(teamId);
		if(team == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
