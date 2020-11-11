package application;

import javafx.stage.Stage;

/**
 * 
 */
public class Game
{
	private int whiteScore;
	private int blackScore;
	private int time = 90; //default time for timer is 90 seconds
	
	private Stage primaryStage;
	private Player blackPlayer;
	private Player whitePlayer;
	private Board board;
	/**
	 * Default constructor
	 */
	public Game(Stage primaryStage, Player p1, Player p2)
	{
		this.primaryStage = primaryStage;
		board = new Board();
	}

	public Game(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	public void addPlayer(Player player){
		if (this.blackPlayer == null) {
			blackPlayer = player;
		} else {
			whitePlayer = player;
		}
	}

	public String getBlackName() {
		return blackPlayer.getName();
	}

	public String getWhiteName() {
		return whitePlayer.getName();
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getGameBoard() {
		return this.board;
	}
	
	public int getWhiteScore()
	{
		return whiteScore;
	}
	
	public int getBlackScore()
	{
		return blackScore;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public void setTime(int seconds)
	{
		this.time = seconds;
	}

	public Stage getStage()
	{
		return primaryStage;
	}
	
}