package com.klgs.rest.gameEngine.www.model;

public class User {
	private String firstName;
	private String lastName;
	private String username; // this should be the primary key
	private String dob;
	private String gender;
	private String voterId; // This should be unique
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", dob=" + dob
				+ ", gender=" + gender + ", voterId=" + voterId + "]";
	}
    
    
}
