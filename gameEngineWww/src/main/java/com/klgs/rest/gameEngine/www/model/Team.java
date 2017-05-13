package com.klgs.rest.gameEngine.www.model;

import java.util.Arrays;
import java.util.List;

public class Team {
	String teamId;
	String teamName;
	List<User> teammates;
	String questionIds[];
	
	public String[] getQuestionIds() {
		return questionIds;
	}
	public void setQuestionsIds(String[] questionIds) {
		this.questionIds = questionIds;
	}
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
	public List<User> getTeammates() {
		return teammates;
	}
	public void setTeammates(List<User> teammates) {
		this.teammates = teammates;
	}
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + " teammates="
				+ Arrays.toString(teammates.toArray()) + ", questionIds=" + Arrays.toString(questionIds) + "]";
	}
	
	public void addteammates(User user){
		this.teammates.add(user);
	}
}
