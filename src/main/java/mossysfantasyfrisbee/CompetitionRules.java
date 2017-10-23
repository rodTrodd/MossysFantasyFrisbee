/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mossysfantasyfrisbee;

/**
 *
 * @author Rowan
 */
public class CompetitionRules {

    private int teamSize;
    private MixedRule mixedRule;//either OPEN, MIXED or LOOSE_MIXED
    private TeamRule teamRule; //either free or one per team
    
    public CompetitionRules(int teamSize, MixedRule mixedRule, TeamRule teamRule) {
        this.teamSize = teamSize;//5or7 depending on the tournament
        this.mixedRule = mixedRule;//mixedRule OPEN, MIXED, LOOSE_MIXED
        this.teamRule = teamRule;//1 player from each team or free to choose
    }

    /**
     * @return the teamSize
     */
    public int getTeamSize() {
        return teamSize;
    }

    /**
     * @return the mixedRule
     */
    public MixedRule getMixedRule() {
        return mixedRule;
    }

    /**
     * @return the teamRule
     */
    public TeamRule getTeamRule() {
        return teamRule;
    }
}
