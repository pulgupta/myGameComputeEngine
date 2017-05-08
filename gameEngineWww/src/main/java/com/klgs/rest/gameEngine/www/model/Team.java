package com.klgs.rest.gameEngine.www.model;

import java.util.Arrays;

public class Team {
	String teamId;
	String teamName;
	String teammatesFull;
	String teammates[];
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
	public String getTeammatesFull() {
		return teammatesFull;
	}
	public void setTeammatesFull(String teammatesFull) {
		this.teammatesFull = teammatesFull;
	}
	public String[] getTeammates() {
		return teammates;
	}
	public void setTeammates(String[] teammates) {
		this.teammates = teammates;
	}

	
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teammatesFull=" + teammatesFull + ", teammates="
				+ Arrays.toString(teammates) + ", questionIds=" + Arrays.toString(questionIds) + "]";
	}
	
	public void splitAndSaveMates() {
		this.teammates = this.teammatesFull.split(",");
	}
	
	
}
