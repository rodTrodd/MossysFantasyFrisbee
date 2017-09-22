package LogicalClasses;

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
    private static ArrayList<Team> teams = new ArrayList<>();
    private static ArrayList<Player> allPlayers = new ArrayList<>();
/**
 * 
 * @param amountOfTeams 
 */
    public Tournament(int amountOfTeams) {
        this.amountOfTeams = amountOfTeams;
        teams.add(new Team("Heat"));
        teams.add(new Team("Poole Ultimate"));
        teams.add(new Team("Dirty Ike and the Boys"));
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
    public static ArrayList<Team> getTournamentTeamList(){
        return teams;
    }
    
    public static ArrayList<Player> getPlayerList(){
        return allPlayers;
    }
    
    public static void addPlayerToTournament(Player p){
        allPlayers.add(p);
    }
}
