package com.example.studentmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDashBoardController {

    @FXML
    private Button ViewAll, Problem, Quizes;

    @FXML
    protected void goToProblemPg() throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("ReportProblem.fxml"));
            Stage stage = (Stage)Problem.getScene().getWindow();
            stage.setScene(new Scene(root, 1024, 570));
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
