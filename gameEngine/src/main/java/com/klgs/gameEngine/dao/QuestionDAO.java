package com.klgs.gameEngine.dao;

import com.klgs.gameEngine.model.Question;

public interface QuestionDAO {
	public void createQuestion(Question question);
	public void updateQuestion(Question question);
	public void deleteQuestion(Question question);
	public Question getQuestion(String questionId);
}
