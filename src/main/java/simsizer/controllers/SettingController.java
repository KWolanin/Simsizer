package simsizer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class SettingController {
    final Properties properties = new Properties();
    public Button save;
    public Button back;
    public Button exitButton;
    public Pane settingPane;
    public CheckBox CatsnDogs;
    public CheckBox CityLiving;
    public CheckBox GetTogether;
    public CheckBox GetFamous;
    public CheckBox IslandLiving;
    public CheckBox OutdoorRetreat;
    public CheckBox Strangerville;
    public CheckBox DiscoverUniversity;
    public CheckBox JungleAdventures;
    public CheckBox Parenthood;
    public CheckBox RealmOfMagic;
    public CheckBox Vampires;
    public Button help;
    public CheckBox GetToWork;
    public CheckBox Moshino;
    public CheckBox Seasons;
    OutputStream outputStream = null;

    @FXML
    public void exit() {
        System.exit(0);
    }

    @SuppressWarnings("EmptyMethod")
    @FXML
    void initialize() {

    }

    @FXML
    public void backToMain() throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        URL settingsScene = new File("src/main/resources/firstScene.fxml").toURI().toURL();
        Parent settingRoot = FXMLLoader.load(settingsScene);
        Scene scene = new Scene(settingRoot, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void newSettings() throws IOException {
        setNewProperty(CatsnDogs);
        setNewProperty(CityLiving);
        setNewProperty(GetTogether);
        setNewProperty(GetFamous);
        setNewProperty(IslandLiving);
        setNewProperty(OutdoorRetreat);
        setNewProperty(Strangerville);
        setNewProperty(DiscoverUniversity);
        setNewProperty(JungleAdventures);
        setNewProperty(Parenthood);
        setNewProperty(RealmOfMagic);
        setNewProperty(Vampires);
        setNewProperty(Seasons);
        setNewProperty(GetToWork);
        setNewProperty(Moshino);
        showSaveMsg();
    }

    private void setNewProperty(CheckBox checkBox) throws IOException {
        String id = checkBox.getId();
        try {
            outputStream = new FileOutputStream("src/main/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (checkBox.isSelected()) {
            properties.setProperty(id, "true");
        } else {
            properties.setProperty(id, "false");
        }
        properties.store(outputStream, null);
    }

    private void showSaveMsg() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Zapisywanie zmian");
        alert.setContentText("Aby zmiany były widoczne, uruchom ponownie program");
        alert.showAndWait();
    }


    public void openHelp() throws IOException {
        Stage stage = (Stage) help.getScene().getWindow();
        URL settingsScene = new File("src/main/resources/help.fxml").toURI().toURL();
        Parent settingRoot = FXMLLoader.load(settingsScene);
        Scene scene = new Scene(settingRoot, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}
