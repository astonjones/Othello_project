package application;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *  Starting point of the othello game. 
 */
public class GameUI extends Application {


	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws InterruptedException
	{
		// displayMainMenu();
		// dispalyLoginForm();

		// create players 1 and 2 object (use output of login form)
		Player p1 = new Player("Jason", "123456");
		Player p2 = new Player("Thomas", "345678");
		Game game = new Game(primaryStage, p1, p2); // create a new game object
		GameBoardUI gbUI = new GameBoardUI(game); // create a new game UI screen
		gbUI.startGame(); // kickoff the gameboard UI
		
		// displayGameOver();
	}


	/**
	 * 
	 */
	public void displayMainMenu() {
		// UI for main menu here
	}

	/**
	 * 
	 */
	public void displayLoginForm() {
		// UI for login form here
	}

	/**
	 * 
	 */
	public void submitLoginForm() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void displayPlayerInfo() {
		// UI for player infomation here
	}



}