package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import static com.example.studentmanagementsystem.Uses.changeScene;
import java.io.IOException;

public class StudentDashBoardController {

    @FXML
    private Button ViewAll, Quizes;

    @FXML
    protected void goToProblemPg(ActionEvent actionEvent) throws IOException {
//            Parent root = FXMLLoader.load(getClass().getResource("ReportProblem.fxml"));
//            Stage stage = (Stage)Problem.getScene().getWindow();
//            stage.setScene(new Scene(root, 1024, 570));
        changeScene(actionEvent, "ReportProblem_Form.fxml", "Log in");
        }

    @FXML
    protected void goToQuizPg() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QuizesAndSurveys_List.fxml"));
        Stage stage = (Stage)Quizes.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    protected void goToMaterialPg() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CourseMaterialAll.fxml"));
        Stage stage = (Stage)ViewAll.getScene().getWindow();
        stage.setScene(new Scene(root, 1024, 570));
    }

    }
