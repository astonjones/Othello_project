package application;

import javafx.stage.Stage;

/**
 * Game class, contains everything needed for a game: 2 players and a board. Optionally an admin.
 *
 * Author (In order of contribution): Aston Jones, Ryan Campbell
 */
public class Game {

    private int whiteScore;
    private int blackScore;
    private int time = 90; //default time for timer is 90 seconds

    private Stage primaryStage;
    private Player blackPlayer;
    private Player whitePlayer;
    private Player admin;
    private Board board;

    /**
     * Default constructor
     */
    public Game(Stage primaryStage, Player p1, Player p2) {
        this.primaryStage = primaryStage;
        board = new Board();
    }
    /**
	 * This constructor may need to be used when an admin logins and no other players have yet logged in
	 * @param primaryStage
	 */
    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addPlayer(Player player) {
        if (player.isAdmin()) {
            this.admin = player;
        } else if (this.blackPlayer == null) {
            blackPlayer = player;
        } else {
            whitePlayer = player;
        }
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getAdmin() {
        return admin;
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

    public int getWhiteScore() {
        return whiteScore;
    }

    public int getBlackScore() {
        return blackScore;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int seconds) {
        this.time = seconds;
    }

    public Stage getStage() {
        return primaryStage;
    }
}
