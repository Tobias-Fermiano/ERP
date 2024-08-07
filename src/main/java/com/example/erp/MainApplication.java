package com.example.erp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("src/main/java/com/example/erp/View/main-view.fxml").toURI().toURL();
        ScrollPane scrollPane = FXMLLoader.load(url);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        mainScene = new Scene(scrollPane);
        stage.setTitle("Testes do JavaFX");
        stage.setScene(mainScene);
        stage.show();
    }

    public static Scene getMainScene() {
        return mainScene;
    }


    public static void main(String[] args) {
        launch();
    }
}