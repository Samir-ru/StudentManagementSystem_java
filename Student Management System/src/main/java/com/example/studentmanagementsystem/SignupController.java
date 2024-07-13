package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import static com.example.studentmanagementsystem.Uses.changeScene;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private TextField Email, Password, FirstName, LastName, Phone;
    @FXML
    private ChoiceBox<String>  Gender;
    private String[] Genders = {"Male", "Female", "Others"};
    @FXML
    protected void onSignup(ActionEvent actionEvent) throws IOException {
        String inputEmail = Email.getText();
        String inputPassword = Password.getText();
        String inputName = FirstName.getText() + " " + LastName.getText();
        String inputPhone = Phone.getText();
        String inputGender = Gender.getValue();

        try (BufferedWriter txtWriter = new BufferedWriter(new FileWriter("Users/" + inputEmail + ".txt"))) {
            txtWriter.write("Email: " + inputEmail);
            txtWriter.newLine();
            txtWriter.write("Name: " + inputName);
            txtWriter.newLine();
            txtWriter.write("Password: " + inputPassword);
            txtWriter.newLine();
            txtWriter.write("Phone: " + inputPhone);
            txtWriter.newLine();
            txtWriter.write("Gender: " + inputGender);
            txtWriter.newLine();
            txtWriter.write("userType: Student");
        }

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter("Users.csv", true))) {
            csvWriter.write(inputEmail + "," + inputPassword + "," + inputName + "," + inputGender + ",Student");
            csvWriter.newLine();
        }
        try {
            changeScene(actionEvent, "StudentDashboard.fxml", "Student Dashboard");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void BackBtn(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "Initials.fxml", "Initials");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Gender.getItems().addAll(Genders);
    }
}
