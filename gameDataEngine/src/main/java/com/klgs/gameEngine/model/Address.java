package com.klgs.gameEngine.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String AddressLine1;
	private String AddressLine2;
	private String city;
	//As of now only value for this will be India
	private String country;
	private String pincode;
	private String description;
	private String comments;
	//In India it can only be string but in other countries it can be anything
	@OneToOne
	private User moderator;
	
	@ElementCollection
	private Set<String> sublocations;
	
	@ElementCollection
	private Set<String> stories;
	
	//GETTER AND SETTERS AND TOSTRING
	
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getModerator() {
		return moderator;
	}
	public void setModerator(User moderator) {
		this.moderator = moderator;
	}
	public Set<String> getSublocations() {
		return sublocations;
	}
	public void setSublocations(Set<String> sublocations) {
		this.sublocations = sublocations;
	}
	public Set<String> getStories() {
		return stories;
	}
	public void setStories(Set<String> stories) {
		this.stories = stories;
	}
	
	@Override
	public String toString() {
		return "Address [AddressLine1=" + AddressLine1 + ", AddressLine2=" + AddressLine2 + ", city=" + city
				+ ", country=" + country + ", pincode=" + pincode + ", description=" + description + ", comments="
				+ comments + ", moderator=" + moderator + ", sublocations=" + sublocations + ", stories=" + stories
				+ "]";
	}
	
}
