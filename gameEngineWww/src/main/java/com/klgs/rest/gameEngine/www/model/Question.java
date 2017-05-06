package com.klgs.rest.gameEngine.www.model;

import java.util.Map;

public class Question {
	
	private String questionId;
	private String question;
	private String optionsFull;
	private String options;
	private String tags;
	private int date;
	private String ownerId;
	private Map<String, Integer> votestatistics;
    
	public void addVote(String option) {
		votestatistics.put(option, votestatistics.get(option)+1);
	}
	
	public int getVote(String option) {
		return votestatistics.get(option);
	}
	
	public boolean checkOption(String option) {
		if(votestatistics.containsKey(option))
			return true;
		return false;
	}
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
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
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", optionsFull=" + optionsFull
				+ ", options=" + options + ", tags=" + tags + ", date=" + date + ", ownerId=" + ownerId + "]";
	}
    
}
