package com.klgs.gameEngine.model;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

/**
 * THe question entity
 * @author pulgupta
 * Each question will either be open to all or to available to certain team ids.
 */

@Entity
public class Question {
	
	@Id
	private String questionId;
	private String question;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="question_options",
			joinColumns=@JoinColumn(name = "questionid", referencedColumnName = "questionId"))
	private Set<String> options;
	private String optionsCsv;
	private String tags;
	private int dateCreated;
	private Date lastUpdated;
	
	//The user who has create this question
	@OneToOne
	private User owner;
	
	private Boolean isPublic;
	//In case the isPublic flag is false then in that case a question will be available to certain teams only 
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "questionIds")
	private Set<Team> teamACL;
	
	@ElementCollection
	@CollectionTable(joinColumns=@JoinColumn(name = "questionid", referencedColumnName = "questionId"))
	private Map<String, Integer> voteStatistics;
    
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

	public Set<Team> getTeamIds() {
		return teamACL;
	}

	public void setTeamIds(Set<Team> teamACL) {
		this.teamACL = teamACL;
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
				+ lastUpdated + ", owner=" + owner + ", isPublic=" + isPublic + ", teamACL=" + teamACL
				+ ", voteStatistics=" + voteStatistics + "]";
	}
    
}
