package com.klgs.gameEngine.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Story {

	@Id
	@GeneratedValue
	private String id;
	
	private String content;
	
	@ManyToOne
	private User author;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="story")
	private List<Comment> comments;
	
	@ManyToOne
	private Address location;
	private Date createdOn;
	private Date updatedOn;
	
	@ElementCollection
	private Set<Tags> tags;
	
	//Keep on increasing these tags
	enum Tags {
		SOCIAL_CAUSE,
		TECHNOLOGY,
		GENERAL_UPDATE,
		JUSTICE_DENIED,
		CRIME,
		PUBLIC_OFFICE_ISSUES
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Story [content=" + content + ", author=" + author + ", comments=" + comments + ", location=" + location
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", tags=" + tags + "]";
	}
}