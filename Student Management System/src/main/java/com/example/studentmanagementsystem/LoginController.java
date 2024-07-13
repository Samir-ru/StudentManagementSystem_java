package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static com.example.studentmanagementsystem.Uses.changeScene;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController{
    @FXML
    private TextField Email, Password;

    @FXML
    protected void onLogin(ActionEvent actionEvent) throws IOException {
        String inputEmail = Email.getText();
        String inputPassword = Password.getText();
        boolean loginSuccessful = false;

        try (BufferedReader csvReader = new BufferedReader(new FileReader("Users.csv"))) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[0].equals(inputEmail) && data[1].equals(inputPassword)) {
                    loginSuccessful = true;
                    break;
                }
            }
        }

        if (loginSuccessful) {
            changeScene(actionEvent, "StudentDashboard.fxml", "Log in");
        } else {
            System.out.println("Login failed. Incorrect email or password.");
        }
    }

    @FXML
    protected void BackBtn(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "Initials.fxml", "Log in");
    }
}
