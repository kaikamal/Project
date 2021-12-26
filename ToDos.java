package com.example.demo2;

import javafx.application.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.awt.Desktop;
import java.io.IOException;


public class ToDos extends Application {

    private final TableView<Task> table1 = new TableView<Task>();
    private final ObservableList<Task> data =
            FXCollections.observableArrayList();

    final HBox hb = new HBox();
    Label response;

    private Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vBox1 = new VBox();
        Scene scene1 = new Scene(vBox1);
        vBox1.setSpacing(4);
        vBox1.setStyle("-fx-background-color: #E1BFE3");

        Label label = new Label("What do I need to do?");
        label.setFont(new Font("Arial", 18));
        label.setPadding(new Insets(10, 10, 10, 10));


        table1.setEditable(true);
        table1.setStyle("-fx-background-color:  #E1BFE3");

        TableColumn descriptionCol = new TableColumn("Description");
        TableColumn deadlineCol = new TableColumn("Deadline");






        descriptionCol.setCellValueFactory(
                new PropertyValueFactory<Task, String>("Description"));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        ((Task) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDescription(t.getNewValue());
                    }
                }
        );
        deadlineCol.setCellValueFactory(
                new PropertyValueFactory<Task, String>("Deadline"));
        deadlineCol.setCellFactory(TextFieldTableCell.forTableColumn());
        deadlineCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        ((Task) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDeadline(t.getNewValue());
                    }
                }
        );

        table1.setItems(data);
        table1.getColumns().addAll(descriptionCol,deadlineCol);
        table1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        descriptionCol.setMinWidth(150);
        deadlineCol.setMinWidth(150);

        HBox hbox1 = new HBox();
        hbox1.setSpacing(4);
        hbox1.setPadding(new Insets(10, 10, 10, 10));

        TextField addDescription = new TextField();
        TextField addDeadline = new TextField();

        addDescription.setPromptText("Enter specific description");
        addDeadline.setPromptText("Enter deadline");

        addDeadline.setPrefWidth(150);
        addDescription.setPrefWidth(150);

        Button btnBack = new Button("Main Menu");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Stage window=(Stage)btnBack.getScene().getWindow();
                window.setScene(new Scene(root));
            }
        });
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Task(
                        addDescription.getText(),
                        addDeadline.getText()));
                addDescription.clear();
                addDeadline.clear();
            }
        });
        Button btnRemove = new Button("Remove");
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {





            }
        });

        hbox1.getChildren().addAll(addDescription,addDeadline, btnAdd,btnRemove,btnBack);

        vBox1.getChildren().addAll(label, table1, hbox1);


        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static class Task {

        private final SimpleStringProperty description;
        private final SimpleStringProperty deadline;

        private Task(String description1,String deadline1) {

            this.description = new SimpleStringProperty(description1);
            this.deadline = new SimpleStringProperty(deadline1);
        }


        public String getDescription() {
            return description.get();
        }
        public void setDescription(String deadline1) {
            description.set(deadline1);
        }
        public String getDeadline() {
            return deadline.get();
        }
        public void setDeadline(String deadline1) {
            deadline.set(deadline1);
        }

    }



}
