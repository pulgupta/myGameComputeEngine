package com.klgs.rest.gameEngine.www.model;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * THe question entity
 * @author pulgupta
 * Each question will either be open to all or to availale to certain team ids.
 */
public class Question {
	
	private String questionId;
	private String question;
	private Set<String> options;
	private String optionsCsv;
	private String tags;
	private int dateCreated;
	private Date lastUpdated;
	
	//The user who has create this question
	private User owner;
	private Boolean isPublic;
	
	//In case the isPublic flag is false then in that case a question will be available to certain teams only 
	private Set<String> teamIds;
	private Map<String, Integer> voteStatistics;
    
	//This being just the entity class we will remove all the business logic out of this class
	/*public void addVote(String option) {
		voteStatistics.put(option, voteStatistics.get(option)+1);
	}
	
	public int getVote(String option) {
		return voteStatistics.get(option);
	}
	
	public boolean checkOption(String option) {
		if(voteStatistics.containsKey(option))
			return true;
		return false;
	}

	//In case we are getting the options as a csv we can create the set out of it using the below method
	public void splitAndSaveQuestion() {
		String[] optionArray = this.optionsCsv.split(",");
		List<String> optionsList = Arrays.asList(optionArray);
		for(String option : optionsList)
			this.options.add(option);
	}
	*/
	//********************GETTERS AND SETTERS*********************************************************
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

	public Set<String> getOptions() {
		return options;
	}

	public void setOptions(Set<String> options) {
		this.options = options;
	}

	public String getOptionsCsv() {
		return optionsCsv;
	}

	public void setOptionsCsv(String optionsCsv) {
		this.optionsCsv = optionsCsv;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(int dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public User getOwnerEmailId() {
		return owner;
	}

	public void setOwnerEmailId(User owner) {
		this.owner = owner;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Set<String> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(Set<String> teamIds) {
		this.teamIds = teamIds;
	}

	public Map<String, Integer> getVotestatistics() {
		return voteStatistics;
	}

	public void setVotestatistics(Map<String, Integer> voteStatistics) {
		this.voteStatistics = voteStatistics;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", options=" + options
				+ ", optionsCsv=" + optionsCsv + ", tags=" + tags + ", dateCreated=" + dateCreated + ", lastUpdated="
				+ lastUpdated + ", owner=" + owner + ", isPublic=" + isPublic + ", teamIds=" + teamIds
				+ ", voteStatistics=" + voteStatistics + "]";
	}
    
}
