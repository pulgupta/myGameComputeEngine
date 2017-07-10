package com.klgs.rest.gameEngine.dao;

import com.klgs.rest.gameEngine.model.Question;

public interface QuestionDAO {
	public void createQuestion(Question question);
	public void updateQuestion(Question question);
	public void deleteQuestion(String questionId);
	public Question getQuestion(String questionId);
}
