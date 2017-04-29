package com.klgs.rest.gameEngine.www.model;

public class Question {
	
	private int questionId;
	private String question;
	private String optionsFull;
	private String options;
	private String tags;
	private int date;
	private int ownerId;
    
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionsFull() {
		return optionsFull;
	}
	public void setOptionsFull(String optionsFull) {
		this.optionsFull = optionsFull;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", optionsFull=" + optionsFull
				+ ", options=" + options + ", tags=" + tags + ", date=" + date + ", ownerId=" + ownerId + "]";
	}
    
}
