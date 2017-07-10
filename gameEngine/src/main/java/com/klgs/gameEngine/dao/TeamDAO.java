package com.klgs.gameEngine.dao;

import com.klgs.gameEngine.model.Team;

public interface TeamDAO {
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(Team team);
	public Team getTeam(String teamId);
}
