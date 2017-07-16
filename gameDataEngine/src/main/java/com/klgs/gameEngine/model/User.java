package com.klgs.gameEngine.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The user Entity will allow us to store user data and link users to teams and questions raised by them
 * @author pulgupta
 * To make things truly anonymous we are not tracking which user has casted which votes.
 * We can only see to which team user belong and which questions he has raised.
 */

@Entity
@Table(name="User", uniqueConstraints = {
		@UniqueConstraint(columnNames = "uid")})
public class User {
	
	//This GUID will only be used to link certain trails. Otherwise we will be using the email ID as the actual primary key
	@JsonIgnore
	private String uid;
	private String FirstName;
	private String LastName;
	
	//This will be the main primary key we will be using for linking the teams
	@Id
	@Column(name="EMAIL", unique = true, nullable = false)
	private String emailId;
	private String userName;
	private Date dob;
	private String Bio;
	private Role role;
	private int credits;
	
	//Email Ids of the followers
	//We can't just use mapping here as that will mean that Hibernate will load the complete tree of followers 
	@ElementCollection
	private Set<String> followers;
	
	enum Role {
		USER,
		MODERATOR,
		ADMIN,
		SUPERUSER
	}
	//A user can be a participant in multiple teams and a team can have multiple users
	
	//Will be false one the user deactivates his account
	@JsonIgnore
	private boolean isActive;
	//Again in this case we don't want Hibernate to load the complete set.
	//We will make a separate REST call in case we need to get the stories
	@ElementCollection
	private Set<String> storiesPublished;
	
	//*************************GETTERS AND SETTERS***********************
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Set<String> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}

	public Set<String> getStoriesPublished() {
		return storiesPublished;
	}

	public void setStoriesPublished(Set<String> storiesPublished) {
		this.storiesPublished = storiesPublished;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", emailId=" + emailId
				+ ", userName=" + userName + ", dob=" + dob + ", Bio=" + Bio + ", role=" + role + ", credits=" + credits
				+ ", followers=" + followers + ", isActive=" + isActive + ", storiesPublished=" + storiesPublished
				+ "]";
	}

}
	
