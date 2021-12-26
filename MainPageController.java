package com.example.demo2;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class MainPageController {

    @FXML
    private Button toDoButton;
    @FXML
    void closeButtonOnClick(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }

    @FXML
    void toDoOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ToDosController.java"));
        Stage window=(Stage)toDoButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    void countdownOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Countdown.fxml"));
        Stage window=(Stage)toDoButton.getScene().getWindow();
        window.setScene(new Scene(root));

    }

}
