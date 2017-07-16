package com.klgs.gameEngine.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String comment;
	private String userEmail;
	//In case this comment is linked to a Story then we will see the story
	@ManyToOne(cascade=CascadeType.ALL)
	private Story story;
	//If this comment is put on another comment then we will see the comment
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private Set<Comment> replies;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Story getStory() {
		return story;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	public Set<Comment> getReplies() {
		return replies;
	}
	public void setReplies(Set<Comment> replies) {
		this.replies = replies;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", userEmail=" + userEmail + ", story=" + story
				+ ", replies=" + replies + "]";
	}
	
}
