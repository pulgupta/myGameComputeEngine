package com.klgs.rest.gameEngine.www.model;

import java.util.Date;
import java.util.Set;

/**
 * The user Entity. This will allow us to store user data and link users to teams
 * @author pulgupta
 * To make things truly anonymous we are not tracking which user has casted which votes.
 * We can only see to which team user belong.
 */
public class User {
	
	private String uid;
	private String FirstName;
	private String LastName;
	
	//This will be the main primary key we will be using for linking the teams
	private String emailId;
	private String userName;
	private Date dob;
	private String Bio;
	
	//A user can be a participant in multiple teams
	private Set<String> teamParticipantUids;

}
