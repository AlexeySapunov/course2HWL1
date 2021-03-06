package ru.geekbrains.homeWork.lesson7.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("ChatWindow");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
