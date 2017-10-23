package com.mossysfantasyfrisbeeg.views;

import static com.gluonhq.charm.glisten.afterburner.DefaultDrawerManager.DRAWER_LAYER;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.mossysfantasyfrisbeeg.MossysFantasyFrisbeeG;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mossysfantasyfrisbee.CompetitionRules;
import mossysfantasyfrisbee.FantasySelection;
import mossysfantasyfrisbee.Gender;
import mossysfantasyfrisbee.MixedRule;
import mossysfantasyfrisbee.Player;
import mossysfantasyfrisbee.Team;
import mossysfantasyfrisbee.TeamRule;

/**
 * This class handles the UI of the Main Menu view. Methods have been migrated
 * from {@link mossysfantasyfrisbee.FXMLDocumentController} to conform to the
 * structure of Gluon.
 *
 * @author Ross
 */
public class MainMenuPresenter extends GluonPresenter<MossysFantasyFrisbeeG> {

    @FXML
    private View mainmenu;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;
    public FantasySelection selection;
    public CompetitionRules rules;

    public void initialize() {
        mainmenu.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = getApp().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e
                        -> getApp().showLayer(DRAWER_LAYER)));
                appBar.setTitleText("MainMenu");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e
                        -> System.out.println("Search")));
            }
        });
        rules = new CompetitionRules(5, MixedRule.MIXED, TeamRule.ONE_PER_TEAM);
        selection = new FantasySelection(1, rules);
    }

    @FXML
    void buttonClick() {
        label.setText(resources.getString("label.text.2"));
    }

    /**
     * Dummy method to test some of the selection logic - to be taken out at a
     * later date
     */
    @FXML
    private void addMalePlayer() {
        Player p = new Player("Bruce");
        p.setTeam(new Team("A")); //ACTUALLY A DIFFERENT TEAM EVERY TIME! Will add more test code later to make this important
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
        p.setTeam(new Team("B")); //ACTUALLY A DIFFERENT TEAM EVERY TIME!
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
