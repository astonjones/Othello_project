package application;

import javafx.stage.Stage;

/**
 * 
 */
public class Game
{
	private int whiteScore;
	private int blackScore;
	private int whiteTime;
	private int blackTime;
	
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

	public void setBoard(Board board){
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
	
	public int getWhiteTime()
	{
		return whiteTime;
	}
	
	public int getBlackTime()
	{
		return blackTime;
	}

	public Stage getStage()
	{
		return primaryStage;
	}
	
}