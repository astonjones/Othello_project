package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/** Original GUI created by Jason McElwee, restructured for game integration by Ryan Campbell. Further edits done by entire team.
 *  STARTING POINT OF THE OTHELLO GAME
 */
public class MainUI extends Application {


	public static void main(String[] args)
	{
		launch(args);
		//launch(args);		
	}

	private StackPane mainPane = new StackPane();

	@Override
	public void start(Stage primaryStage) throws InterruptedException, PasswordException
	{

		// setup UI
        VBox vBox = new VBox();
        vBox.setSpacing(8);
		vBox.setPadding(new Insets(10,10,10,10));
		
		Button loginP1 = new Button("Login Player 1");
		Button loginP2 = new Button("Login Player 2");
		Button playGame = new Button("Play Game");
		Button viewRecords = new Button("View Records");
		Button exit = new Button("Exit Game");

        vBox.getChildren().addAll(
			   loginP1,
			   loginP2,
			   playGame,
			   viewRecords
		);
		
		mainPane.getChildren().addAll(vBox);
		
		Stage secondaryStage = new Stage();

	    // let player 1 login
        loginP1.setOnAction(actionEvent-> {
			LoginUI loginUI = new LoginUI();
			Player p1 = loginUI.initializeUI(secondaryStage);
			// TODO: display player 1 logged in
		});

		// let player 2 login
		loginP2.setOnAction(actionEvent-> {
			LoginUI loginUI = new LoginUI();
			Player p2 = loginUI.initializeUI(secondaryStage);
			// TODO display player 2 logged in
		});

		// Play the game iff two players have logged in
		playGame.setOnAction(actionEvent-> {
			Game game = new Game(secondaryStage, p1, p2);
			GameBoardUI gbUI = new GameBoardUI(game);
			gbUI.startGame();
		});

		viewRecords.setOnAction(actionEvent-> {
			RecordsUI recordsUI = new RecordsUI();
			recordsUI.initializeUI(secondaryStage);
		});
		
		exit.setOnAction(actionEvent-> {
			primaryStage.close();
		});

        // starts the UI
		mainPane.setStyle("-fx-background-color:#520100;");
		Scene loginScene = new Scene(mainPane,300,200);
		primaryStage.setTitle("Main Menu");
		primaryStage.setScene(loginScene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(true);


	}
}