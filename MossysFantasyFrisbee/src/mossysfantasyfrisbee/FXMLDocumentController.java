/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mossysfantasyfrisbee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * This is where the code that handles the UI will live. It'll probably work out
 * that some of the functionality will find itself in here, but we'll see what
 * happens.
 *
 * @author Rowan
 */
public class FXMLDocumentController implements Initializable {

    CompetitionRules rules;
    FantasySelection selection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rules = new CompetitionRules(5, MixedRule.MIXED, TeamRule.ONE_PER_TEAM);
        selection = new FantasySelection(1, rules);
    }

    /**
     * Dummy method to test some of the selection logic - to be taken out at a
     * later date
     */
    @FXML
    private void addMalePlayer() {
        Player p = new Player("Bruce");
        p.setTeam(new Team("A"));//ACTUALLY A DIFFERENT TEAM EVERY TIME! Will add more test code later to make this important
        p.setGender(Gender.MALE);
        String error = selection.addPlayer(p);
        if (error != null) {
            System.out.println(error);
        } else {
            selection.addPlayer(p);
            System.out.println("Now the selection is ");
            for (Player player : selection.getSelection()) {
                System.out.println(player.getName());
            }
        }
    }

    /**
     * Dummy method to test some of the selection logic - to be taken out at a
     * later date
     */
    @FXML
    private void addFemalePlayer() {
        Player p = new Player("Sheila");
        p.setTeam(new Team("B"));//ACTUALLY A DIFFERENT TEAM EVERY TIME!
        p.setGender(Gender.FEMALE);
        String error = selection.addPlayer(p);
        if (error != null) {
            System.out.println(error);
        } else {
            System.out.println("Now the selection is ");
            for (Player player : selection.getSelection()) {
                System.out.println(player.getName());
            }
        }

    }

}
