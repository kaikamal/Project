package com.example.demo2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class LoginController {

    private String password1 = "123";
    private String username = "user";


    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    public void loginButtonOnClick(ActionEvent e) throws IOException {
        String name = nameTextField.getText();
        String password = passwordTextField.getText();

        if (name.matches(username) && password.matches(password1)) {
                Stage stage = (Stage) nameTextField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
            }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Warning");
            alert.setContentText("Wrong password or username!");
            alert.showAndWait();
        }
    }
    @FXML
    void closeButtonOnClick(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

    }
}
