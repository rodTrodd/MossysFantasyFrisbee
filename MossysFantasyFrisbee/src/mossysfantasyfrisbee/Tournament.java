package mossysfantasyfrisbee;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rowan
 */
public class Tournament {

    private final int amountOfTeams;
    private ArrayList<Team> teams;
/**
 * 
 * @param amountOfTeams 
 */
    public Tournament(int amountOfTeams) {
        this.amountOfTeams = amountOfTeams;
    }
    
    /**
     * 
     * @param team 
     */
    public void addTeam(Team team){
        if(teams.size()<=amountOfTeams){
            teams.add(team);
        }
    }
    
    /**
     * 
     * @param team 
     */
    public void removeTeam(Team team){
        teams.remove(team);
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Team> getTournamentTeamList(){
        return teams;
    }
}
