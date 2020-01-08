package simsizer.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static simsizer.controllers.Controller.rb;

public class Help {
    public Button back;
    public Button exit;

    public void exit() {
        System.exit(0);
    }

    public void back() throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        URL settingsScene = new File("src/main/resources/setting.fxml").toURI().toURL();
        Parent settingRoot = FXMLLoader.load(settingsScene, rb);
        Scene scene = new Scene(settingRoot, 500, 400);
        stage.setScene(scene);
    }
}
