package com.klgs.rest.gameEngine.dao;

import com.klgs.rest.gameEngine.model.Team;

public interface TeamDAO {
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(String teamId);
	public Team getTeam(String teamId);
}
