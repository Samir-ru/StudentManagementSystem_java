package com.example.studentmanagementsystem;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ReportProblemController {
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    public void onSubmit(){
        String Title = title.getText();
        String Message = description.getText();
        try (BufferedWriter txtWriter = new BufferedWriter(new FileWriter("Problems/Problem.txt"))) {
            txtWriter.write("Title: " + Title);
            txtWriter.newLine();
            txtWriter.write("Message: " + Message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        }
