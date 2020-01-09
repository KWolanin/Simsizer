package simsizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class Main extends Application {

    private static void startApp(Stage primaryStage) throws java.io.IOException {
        URL firstSceneURL = new File("src/main/resources/firstScene.fxml").toURI().toURL();
        Parent firstSceneRoot = FXMLLoader.load(firstSceneURL);
        Scene firstScene = new Scene(firstSceneRoot, 500, 400);
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Simsizer");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        startApp(primaryStage);
    }
}


