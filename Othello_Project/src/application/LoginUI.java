package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.Button;

/**
 * created by Jason McElwee This class displays a window for a player or
 * administrator to log in
 */

public class LoginUI extends Application {

    private StackPane loginPane = new StackPane();
    private Player player;

    // stage settings for when it starts
    public void start(Stage loginStage) {

        // setup UI
        // Button button = new Button("OPEN");
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        Label username = new Label("Username");
        username.setTextFill(Color.WHITE);
        TextField userField = new TextField();

        Label password = new Label("Password");
        password.setTextFill(Color.WHITE);
        PasswordField passField = new PasswordField();

        Button login = new Button("Login");

        vBox.getChildren().addAll(username, userField, password, passField, login);
        loginPane.getChildren().addAll(vBox);

        // gives button purpose
        login.setOnAction(actionEvent -> {
            try {
                player = new Player(userField.getText(), passField.getText());
                System.out.println("Login Successs.");
                loginStage.close();
            } catch (PasswordException e) {
                // If the exception 
                System.out.println("Incorrect Password.");
                // TODO: popup message for incorrect password
            }
        });
        
        // starts the UI
		loginPane.setStyle("-fx-background-color:#520100;");
		Scene loginScene = new Scene(loginPane,300,200);
		loginStage.setTitle("Login");
		loginStage.setScene(loginScene);
		loginStage.show();
		loginStage.setAlwaysOnTop(true);
    }

    public Player initializeUI (Stage loginStage) {
        start(loginStage);
        return player;
    }
    
}
