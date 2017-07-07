package com.klgs.rest.gameEngine.model;

import java.util.Set;

public class Team {
	String teamId;
	String teamName;
	//The user who has created the team and thus is the default owner of the team
	//Only this user can edit the team
	User owner;
	Set<User> teammates;
	
	//List of all the questions on which this team has access
	Set<String> questionIds;

	//******************************GETTERS AND SETTERS*************************
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getTeammates() {
		return teammates;
	}

	public void setTeammates(Set<User> teammates) {
		this.teammates = teammates;
	}

	public Set<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(Set<String> questionIds) {
		this.questionIds = questionIds;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", owner=" + owner + ", teammates=" + teammates
				+ ", questionIds=" + questionIds + "]";
	}
		
}