package com.klgs.rest.gameEngine.www.model;

import java.util.Date;
import java.util.Set;

/**
 * The user Entity. This will allow us to store user data and link users to teams
 * @author pulgupta
 * To make things truly anonymous we are not tracking which user has casted which votes.
 * We can only see to which team user belong.
 */
public class User {
	
	private String uid;
	private String FirstName;
	private String LastName;
	
	//This will be the main primary key we will be using for linking the teams
	private String emailId;
	private String userName;
	private Date dob;
	private String Bio;
	
	//A user can be a participant in multiple teams
	private Set<String> teamParticipantUids;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	public Set<String> getTeamParticipantUids() {
		return teamParticipantUids;
	}

	public void setTeamParticipantUids(Set<String> teamParticipantUids) {
		this.teamParticipantUids = teamParticipantUids;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", emailId=" + emailId
				+ ", userName=" + userName + ", dob=" + dob + ", Bio=" + Bio + ", teamParticipantUids="
				+ teamParticipantUids + "]";
	}
}
