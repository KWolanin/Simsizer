package simsizer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import simsizer.DLCSelector;
import simsizer.randomizers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {

    public static final ResourceBundle rb = ResourceBundle.getBundle("my", Locale.getDefault());
    public static final String traitMsgBase = "Cecha:\t\t\t";
    public static final String aspirationMsgBase = "Aspiracja:\t\t\t";
    public static final String orientationMsgBase = "Orientacja:\t\t";
    public static final String fulltimejobMsgBase = "Kariera:\t\t\t";
    public static final String parttimejobMsgBase = "Praca dorywcza:\t";
    public static int traitAmountForRandomize;
    @FXML
    public CheckBox orientation;
    public Button settings;
    public Button exitButton;
    public RadioButton todler;
    public CheckBox work;
    public CheckBox aspiration;
    public CheckBox parttimeWork;
    public ToggleGroup ageGroup;
    public Pane mainPane;
    public RadioButton children;
    public ComboBox<Integer> traitAmount;
    public RadioButton teen;

    private static String prepareTraitMsg() {
        return Controller.traitMsgBase + TraitRandomizer.traitMsg;
    }

    private static String prepareAspirationMsg() {
        return aspirationMsgBase + AspirationRandomizer.randomizeAspiration();
    }

    private static String prepareOrientationMsg() throws FileNotFoundException {
        return orientationMsgBase + SexualOrientationRandomizer.randomizeOrientation();
    }

    private static String prepareFulltimeJobMsg() {
        return fulltimejobMsgBase + FulltimeRandomizer.randomizeFulltimeJob();
    }

    private static String prepareParttimeJobMsg() {
        return parttimejobMsgBase + ParttimeRandomizer.randomizeParttimeJob();
    }

    @FXML
    void initialize() {
        traitAmount.getItems().removeAll(traitAmount.getItems());
        traitAmount.getItems().addAll(1, 2, 3);
        traitAmount.getSelectionModel().select(3);
        traitAmount.setValue(1);
    }

    @FXML
    public void openSettings() throws IOException {
        Stage stage = (Stage) settings.getScene().getWindow();
        URL settingsScene = new File("src/main/resources/setting.fxml").toURI().toURL();
        Parent settingRoot = FXMLLoader.load(settingsScene, rb);
        Scene scene = new Scene(settingRoot, 500, 400);
        stage.setScene(scene);
    }

    @FXML
    public void randomizeIt() throws IOException {
        traitAmountForRandomize = traitAmount.getValue();
        DLCSelector.mergeSelectedDLC();
        checkUserSelectedOptions();
        showRandomizedMsg();
    }

    private void checkUserSelectedOptions() throws FileNotFoundException {
        if (todler.isSelected()) {
            TraitRandomizer.randomizeToddlerTraits();
        } else if (children.isSelected()) {
            TraitRandomizer.randomizeAdultTraits();
            if (aspiration.isSelected()) {
                AspirationRandomizer.randomizeChildAspiration();
            }
        } else if (teen.isSelected()) {
            ParttimeRandomizer.randomizeTeenParttimeJob();
            TraitRandomizer.randomizeAdultTraits();
        } else {
            TraitRandomizer.randomizeAdultTraits();
            if (orientation.isSelected()) {
                SexualOrientationRandomizer.randomizeOrientation();
            }
            if (aspiration.isSelected()) {
                AspirationRandomizer.randomizeAdultAspiration();
            }
            if (parttimeWork.isSelected()) {
                ParttimeRandomizer.randomizeAdultParttimeJob();
            }
        }
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    public void enableOptionsForToddler() {
        orientation.setDisable(true);
        work.setDisable(true);
        parttimeWork.setDisable(true);
        aspiration.setDisable(true);
        orientation.setSelected(false);
        work.setSelected(false);
        parttimeWork.setSelected(false);
        aspiration.setSelected(false);
        traitAmount.setDisable(true);
    }

    public void enableOptionsForTeen() {
        orientation.setDisable(false);
        work.setDisable(true);
        work.setSelected(false);
        parttimeWork.setDisable(false);
        aspiration.setDisable(false);
        traitAmount.setDisable(false);
    }

    public void enableOptionsForAdult() {
        orientation.setDisable(false);
        work.setDisable(false);
        parttimeWork.setDisable(false);
        aspiration.setDisable(false);
        traitAmount.setDisable(false);

    }

    public void enableOptionsForChild() {
        parttimeWork.setDisable(true);
        parttimeWork.setSelected(false);
        work.setDisable(true);
        work.setSelected(false);
        orientation.setDisable(true);
        orientation.setSelected(false);
        aspiration.setDisable(false);
        traitAmount.setDisable(false);
    }

    public void showRandomizedMsg() throws FileNotFoundException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Wyniki losowania");
        alert.setContentText(prepareWholeMessage());
        alert.showAndWait();
    }

    private String prepareWholeMessage() throws FileNotFoundException {
        String message = prepareTraitMsg();
        if (aspiration.isSelected()) {
            message += "\n";
            message += prepareAspirationMsg();
        }
        if (orientation.isSelected()) {
            message += "\n";
            message += prepareOrientationMsg();
        }
        if (work.isSelected()) {
            message += "\n";
            message += prepareFulltimeJobMsg();
        }
        if (parttimeWork.isSelected()) {
            message += "\n";
            message += prepareParttimeJobMsg();
        }
        return message;
    }
}
