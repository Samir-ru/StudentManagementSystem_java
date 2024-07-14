package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import static com.example.studentmanagementsystem.Uses.changeScene;
import java.io.*;

public class LoginController {
    @FXML
    private TextField Email, Password;

    @FXML
    protected void onLogin(ActionEvent actionEvent) throws IOException {
        String inputEmail = Email.getText();
        String inputPassword = Password.getText();
        String role = "";

        try (BufferedReader csvReader = new BufferedReader(new FileReader("Users.csv"))) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data.length >= 5 && data[1].equals(inputEmail) && data[2].equals(inputPassword)) {
                    role = data[5].trim();
                    break;
                }
            }
        }

        if (!role.isEmpty()) {
            switch (role) {
                case "Student":
                    changeScene(actionEvent, "StudentDashboard.fxml", "Student's Dashboard");
                    break;
                case "Teacher":
                    changeScene(actionEvent, "TeacherDashboard.fxml", "Teacher's Dashboard");
                    break;
                default:
                    System.out.println("Unknown role: " + role);
            }
        } else {
            System.out.println("Login failed. Incorrect email or password.");
        }
    }

    @FXML
    protected void BackBtn(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "Initials.fxml", "Log in");
    }
}

