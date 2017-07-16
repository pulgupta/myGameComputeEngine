package com.klgs.gameEngine.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Story {

	private String content;
	private User author;
	private List<Comment> comments;
	private Address location;
	private Date createdOn;
	private Date updatedOn;
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
}
