package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Main Menu, This is first window that a user sees, and kicks off any other game action
 *
 * Author (In order of contribution): Jason McElwee (UI Work), Ryan Campbell (Button Logic), Thomas King
 */

public class MainUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Game game;

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        game = new Game(primaryStage);

        // setup UI
        StackPane mainPane = new StackPane();
        VBox vBox = new VBox();
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        Button loginP1 = new Button("Login Player 1");
        Button loginP2 = new Button("Login Player 2");
        Button playGame = new Button("Play Game");
        Button viewRecords = new Button("View Records");
        Button exit = new Button("Exit Game");
        Button rules = new Button("Change Game Rules");

        vBox
            .getChildren()
            .addAll(loginP1, loginP2, playGame, viewRecords, rules);

        mainPane.getChildren().addAll(vBox);

        Stage secondaryStage = new Stage();
        secondaryStage.getIcons().add(new Image("file:icon.PNG"));

        // let player 1 login
        loginP1.setOnAction(
            actionEvent -> {
                startLoginUI(secondaryStage);
            }
        );

        // let player 2 login
        loginP2.setOnAction(
            actionEvent -> {
                startLoginUI(secondaryStage);
            }
        );

        // Play the game iff two players have logged in
        playGame.setOnAction(
            actionEvent -> {
                GameBoardUI gbUI = new GameBoardUI(game);
                GameTimer timer = new GameTimer(gbUI);
                gbUI.startGame();
            }
		);
		
		// Kickoff the RecordsUI
        viewRecords.setOnAction(
            actionEvent -> {
                RecordsUI recordsUI = new RecordsUI();
                recordsUI.initializeUI(secondaryStage);
            }
        );

		// Kickoff the rules ui
        rules.setOnAction(
            actionEvent -> {
                startAdminLogin(secondaryStage);
            }
        );

		// exit the game
        exit.setOnAction(
            actionEvent -> {
                primaryStage.close();
            }
        );

        // starts the Main Menu
        mainPane.setStyle("-fx-background-color:#520100;");
        Scene loginScene = new Scene(mainPane, 300, 200);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(loginScene);
        primaryStage.getIcons().add(new Image("file:icon.PNG"));
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    /**
     * UI for logging into a game
     * @param loginStage
     */
    public void startLoginUI(Stage loginStage) {
        StackPane loginPane = new StackPane();
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

        vBox
            .getChildren()
            .addAll(username, userField, password, passField, login);
        loginPane.getChildren().addAll(vBox);

        // gives button purpose
        login.setOnAction(
            actionEvent -> {
                try {
                    Player player = new Player(
                        userField.getText(),
                        passField.getText(),
                        false
                    );
                    System.out.println("Login Successs.");
                    game.addPlayer(player);
                    loginStage.close();
                } catch (PasswordException e) {
                    // If the exception
                    System.out.println("Incorrect Password.");
                    Text incorrectPass = new Text("Name or Password Invalid ");
                    incorrectPass.setFill(Color.WHITE);
                    vBox.getChildren().addAll(incorrectPass);
                }
            }
        );

        // starts the UI
        loginPane.setStyle("-fx-background-color:#520100;");
        Scene loginScene = new Scene(loginPane, 300, 200);
        loginStage.setTitle("Login");
        loginStage.setScene(loginScene);
        loginStage.getIcons().add(new Image("file:icon.PNG"));
        loginStage.show();
        loginStage.setAlwaysOnTop(true);
    }

    /**
     * UI for logging into a game
     * @param loginStage
     */
    public void startAdminLogin(Stage loginStage) {
        Text adminText = new Text();

        StackPane loginPane = new StackPane();
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
        Button exit = new Button("Exit");

        vBox
            .getChildren()
            .addAll(username, userField, password, passField, login, exit);
        loginPane.getChildren().addAll(vBox);

        // gives button purpose
        login.setOnAction(
            actionEvent -> {
                try {
                    Player player = new Player(
                        userField.getText(),
                        passField.getText(),
                        true
                    );
                    System.out.println("Login Successs.");

                    RulesUI rulesUI = new RulesUI(loginStage, adminText, game);
                    rulesUI.openUI();
                } catch (PasswordException e) {
                    // If the exception
                    System.out.println("Incorrect Password.");
                    Text incorrectPass = new Text("Incorrect Password");
                    incorrectPass.setFill(Color.WHITE);
                    vBox.getChildren().addAll(incorrectPass);
                }
            }
        );

        exit.setOnAction(
            actionEvent -> {
                loginStage.close();
            }
        );

        // starts the UI
        loginPane.setStyle("-fx-background-color:#520100;");
        Scene loginScene = new Scene(loginPane, 300, 200);
        loginStage.setTitle("Login");
        loginStage.setScene(loginScene);
        loginStage.getIcons().add(new Image("file:icon.PNG"));
        loginStage.show();
        loginStage.setAlwaysOnTop(true);
    }
}
