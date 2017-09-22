/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicalClasses.Gender;
import LogicalClasses.Player;
import LogicalClasses.Team;
import LogicalClasses.Tournament;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Rowan
 */
public class PlayerEntryFormController implements Initializable {

    private final ToggleGroup genderToggleGroup = new ToggleGroup();

    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private RadioButton rbOther;
    @FXML
    private TextField txfName;
    @FXML
    private TextField txfShirtNumber;
    @FXML
    private ComboBox cbxTeam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Team> teamsInTournament = getAvailableTeams(); //would query the database here, I'll come up with something hacky in the meantime!
        
        for (Team t : teamsInTournament) {
            cbxTeam.getItems().add(t.getTeamName());
        }
        rbFemale.setToggleGroup(genderToggleGroup);
        rbMale.setToggleGroup(genderToggleGroup);
        rbOther.setToggleGroup(genderToggleGroup);
        rbFemale.setSelected(true);
    }

    @FXML
    private void trySubmit() {

        if (txfName.getText().equalsIgnoreCase("") || cbxTeam.getValue() == null) {
            System.out.println("You had 1 job and you failed, be sure to enter a name and select the team");
        } else if (txfShirtNumber.getText().equalsIgnoreCase("")) {
            System.err.println("Spinner Fail");
        } else {
            Player p = new Player(txfName.getText());

            p.setShirtNum(txfShirtNumber.getText());
            
            if (rbFemale.isSelected()) {
                p.setGender(Gender.FEMALE);
            } else if (rbMale.isSelected()) {
                p.setGender(Gender.MALE);
            } else {
                p.setGender(Gender.UNKNOWN);
            }
            String teamName = cbxTeam.getValue().toString();
            Team team = null;
            for (Team t : getAvailableTeams()) {
                if (t.getTeamName().equalsIgnoreCase(teamName)) {
                    team = t;
                }
            }
            p.setTeam(team);
            
            Tournament.addPlayerToTournament(p);
            System.out.println("Boom, player added");
        }
    }

    private ArrayList<Team> getAvailableTeams() {
        return Tournament.getTournamentTeamList();
    }
}
