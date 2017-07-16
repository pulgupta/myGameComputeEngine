package com.klgs.gameEngine.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.klgs.gameEngine.model.Story;

@Component
public interface StoryDAO {

	public void createStory(Story story);
	public void updateStory(Story story);
	public void deleteStory(Story story);
	public Story getStory(String id);
	public Set<Story> getStoryByAuthor(String user);
	
}
