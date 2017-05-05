package com.klgs.rest.gameEngine.www.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.klgs.rest.gameEngine.www.model.Question;
import com.klgs.rest.gameEngine.www.model.Team;

@Component
public class InMemoryStore {
	Map<String, Question> questionStore = null;
	Map<String, Team> teamStore = null;

	public InMemoryStore() {
		super();
		this.questionStore = new HashMap<String, Question>();
		this.teamStore = new HashMap<String, Team>();
	}

	public void addQuestion(Question question) {
		this.questionStore.put(question.getQuestionId(), question);
	}

	public Question getQuestion(String questionId) {
		return questionStore.get(questionId);
	}

	public void addTeam(Team team) {
		this.teamStore.put(team.getTeamId(), team);
	}

	public Team getTeam(String teamId) {
		return teamStore.get(teamId);
	}
}
