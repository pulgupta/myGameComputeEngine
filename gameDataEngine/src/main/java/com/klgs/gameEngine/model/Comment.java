package com.klgs.gameEngine.model;

public class Comment {
	
	private String id;
	private String comment;
	//In case this comment is linked to a Story then we will see the story
	private Story story;
	//If this comment is put on another comment then we will see the comment
	private Comment parentComment;
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
	public Comment getParentComment() {
		return parentComment;
	}
	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", story=" + story + ", parentComment=" + parentComment
				+ "]";
	}	

}
