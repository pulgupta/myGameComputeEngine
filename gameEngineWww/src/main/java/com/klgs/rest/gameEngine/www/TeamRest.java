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

import com.klgs.rest.gameEngine.www.model.Team;
import com.klgs.rest.gameEngine.www.model.User;
import com.klgs.rest.gameEngine.www.util.InMemoryStore;
import com.klgs.rest.gameEngine.www.util.UuidGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/team")
public class TeamRest {

	@Autowired
	InMemoryStore store;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	// This will create a team. This will usually be an empty team and then we will add users to the team
	@RequestMapping(value="", method=RequestMethod.POST)
	public Team saveTeam(@RequestBody Team team) {
		System.out.println("This is inside the post method of Team" + team);
		String teamId = UuidGenerator.generateUuid();
		team.setTeamId(teamId);
		store.addTeam(team);
		return team;
	}
	
	@RequestMapping(value="/{teamId}", method=RequestMethod.GET)
	public ResponseEntity<Team> getTeam(@PathVariable String teamId) {
		Team team = store.getTeam(teamId);
		log.info("Inside get by id of teams");
		if(team == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else { 
			log.info(team.toString());
			return new ResponseEntity<Team>(team, HttpStatus.OK);
		}
	}
	
	// This method will add a user to a team
	@RequestMapping(value="/{teamId}", method=RequestMethod.PUT)
	public ResponseEntity<Team> getTeam(@RequestBody String userName, @PathVariable String teamId) {
		Team team = store.getTeam(teamId);
		log.info("Inside put of teams");
		if(team == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else { 
			User user = store.getUser(userName);
			if(user == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			team.addteammates(user);
			return new ResponseEntity<Team>(team, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/version.info", method=RequestMethod.GET, produces="application/json")
	public String verionInfo() {
		return "1.0";
	}
}
