/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicalClasses.Gender;
import LogicalClasses.Player;
import LogicalClasses.Team;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Rowan
 */
public class PlayerEntryFormController implements Initializable {

    private ToggleGroup genderToggleGroup = new ToggleGroup();

    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private RadioButton rbOther;
    @FXML
    private TextField txfName;
    @FXML
    private Spinner spnShirtNumber;
    @FXML
    private ComboBox cbxTeam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Team> teamsInTournament = getAvailableTeams(); //would query the database here, I'll come up with something hacky in the meantime!
        rbFemale.setToggleGroup(genderToggleGroup);
        rbMale.setToggleGroup(genderToggleGroup);
        rbOther.setToggleGroup(genderToggleGroup);
    }

    @FXML
    private void trySubmit() {

        if (txfName.getText().equalsIgnoreCase("") || cbxTeam.getValue() == null) {
            System.out.println("You had 1 job and you failed, be sure to enter a name and select the team");
        } else {
            Player p = new Player(txfName.getText());
            p.setShirtNum((String) spnShirtNumber.getValue());
            if (rbFemale.isSelected()) {
                p.setGender(Gender.FEMALE);
            } else if (rbMale.isSelected()) {
                p.setGender(Gender.MALE);
            } else {
                p.setGender(Gender.UNKNOWN);
            }
            Team team = (Team) cbxTeam.getValue();
            p.setTeam(team);
        }
    }

    private ArrayList<Team> getAvailableTeams() {
        return Tournament.getTeamList();
    }
}
