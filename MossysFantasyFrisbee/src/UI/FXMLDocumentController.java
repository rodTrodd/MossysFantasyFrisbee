/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import LogicalClasses.CompetitionRules;
import LogicalClasses.FantasySelection;
import LogicalClasses.MixedRule;
import LogicalClasses.Player;
import LogicalClasses.Team;
import LogicalClasses.TeamRule;
import LogicalClasses.Tournament;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * This is where the code that handles the UI will live. It'll probably work out
 * that some of the functionality will find itself in here, but we'll see what
 * happens.
 *
 * @author Rowan
 */
public class FXMLDocumentController implements Initializable {

    private CompetitionRules rules;
    private FantasySelection selection;

    @FXML
    private AnchorPane appAnchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tournament tournament = new Tournament(4);
        tournament.addTeam(new Team("Dorset"));
        rules = new CompetitionRules(5, MixedRule.MIXED, TeamRule.ONE_PER_TEAM);
        selection = new FantasySelection(1, rules);
    }

    /**
     * Dummy method to test some of the selection logic - to be taken out at a
     * later date
     */
    @FXML
    private void addNewPlayer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/UI/PlayerEntryForm.fxml"));
        //appAnchor.getChildren().remove(0);
        Dialog<Player> dialog = new Dialog();
        dialog.setTitle("New Player");
        dialog.setHeaderText("Fill in all of the fields in the form below...");
        dialog.setResizable(true);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.setResultConverter((ButtonType b) -> {
            if (b == buttonTypeOk) {
                PlayerEntryFormController pefc = (PlayerEntryFormController) fxmlLoader.getController();
                if (pefc != null) {

                    if (pefc.submission() == null) {
                        //Do something to relay reason for invalidness to user.
                        pefc.highlightInvalidFields();
                    } else {
                        return pefc.submission();
                    }
                }
            }
            return null;
        });
        while (dialog.getResult() == null) {
            dialog.showAndWait();
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "It worked, the player has been added", ButtonType.OK);
        a.show();
    }
}
