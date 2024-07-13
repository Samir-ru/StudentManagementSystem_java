package com.example.studentmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Initials.fxml"));
        stage.setTitle("Initials");
        stage.setScene(new Scene(root, 1024, 570));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}