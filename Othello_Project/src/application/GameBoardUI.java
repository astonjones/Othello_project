package application;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** Original GUI created by Jason McElwee, later restructured for game integration by Ryan Campbell and Thomas King
 * further edits done by entire team
 */
public class GameBoardUI {
	// board is now included in the game object
	public static Game game;
	static GameTimer blackTimer;
	static GameTimer whiteTimer;

	public static ObservableList<Node> othello;
	public static ArrayList<Circle> discs = new ArrayList<Circle>();

	//Textfield objects
	static TextField P1Timer = new TextField();
	static TextField P2Timer = new TextField();
	
	/**
	 * Default constructor
	 */
	public GameBoardUI(Game game)
	{
		this.game = game;
		this.blackTimer = new GameTimer(P1Timer, this.game);
		this.whiteTimer = new GameTimer(P2Timer, this.game);
	}

	/**
	 * draws the game board UI
	 * 
	 */
	public void startGame() {
		
		Pane rootPane = new Pane();
		rootPane.setStyle("-fx-background-color:#520100;");
		
		othello = rootPane.getChildren();
		
		Rectangle P1 = new Rectangle(900,128,200,150);
		P1.setStroke(Color.BLACK);
		P1.setFill(Color.BLACK);
		P1.setArcHeight(20);
		P1.setArcWidth(20);
		
		Rectangle P1Border = new Rectangle(890,118,220,170);
		P1Border.setStroke(Color.YELLOW);
		P1Border.setFill(Color.YELLOW);
		P1Border.setArcHeight(20);
		P1Border.setArcWidth(20);
	
		Rectangle P2 = new Rectangle(900,348,200,150);
		P2.setStroke(Color.BLACK);
		P2.setFill(Color.WHITE);
		P2.setArcHeight(20);
		P2.setArcWidth(20);
		
		Rectangle P2Border = new Rectangle(890,338,220,170);
		P2Border.setStroke(Color.YELLOW);
		P2Border.setFill(Color.YELLOW);
		P2Border.setArcHeight(20);
		P2Border.setArcWidth(20);
		
		Rectangle boardBorder = new Rectangle(140,118,420,420);
		boardBorder.setStroke(Color.BLACK);
		boardBorder.setFill(Color.BLACK);	
		boardBorder.setArcHeight(20);
		boardBorder.setArcWidth(20);
		
		Rectangle P1Score = new Rectangle(600,118,100,210);
		P1Score.setStroke(Color.BLACK);
		P1Score.setFill(Color.BLACK);
		P1Score.setArcHeight(20);
		P1Score.setArcWidth(20);
		
		Rectangle P2Score = new Rectangle(600,328,100,210);
		P2Score.setStroke(Color.BLACK);
		P2Score.setFill(Color.WHITE);
		P2Score.setArcHeight(20);
		P2Score.setArcWidth(20);
		
		TextField P1Name = new TextField(game.getBlackName());
		P1Name.setLayoutX(924);
		P1Name.setLayoutY(160);
		
		P1Timer.setLayoutX(924);
		P1Timer.setLayoutY(220);
		
		TextField P2Name = new TextField(game.getWhiteName());
		P2Name.setLayoutX(924);
		P2Name.setLayoutY(380);
		
		P2Timer.setLayoutX(924);
		P2Timer.setLayoutY(440);
		
		Text P1S = new Text("2");
		P1S.setLayoutX(645);
		P1S.setLayoutY(308);
		P1S.setFont(new Font("Arial Narrow", 30));
		P1S.setFill(Color.WHITE);
		
		Text P2S = new Text("2");
		P2S.setLayoutX(645);
		P2S.setLayoutY(358);
		P2S.setFont(new Font("Arial Narrow", 30));
		
		othello.addAll(boardBorder,P1Border,P1,P2,P1Score,P2Score,P1S,P2S,P1Name,P1Timer,P2Name,P2Timer);
		
		Rectangle[][] tiles = new Rectangle[8][8];
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				Rectangle tile = new Rectangle(50*i+150, 50*j+128, 50, 50);
				tile.setStroke(Color.BLACK);
				tile.setFill(Color.GREEN);
				tiles[i][j] = tile;
			}
		}
		
		game.setBoard(new Board());
		
		for(Rectangle[] r : tiles)
		{
			for(Rectangle r2 : r)
			{
				othello.add(r2);
			}
		}
		
		Button pass = new Button("Pass");
		Button quit = new Button("Quit");
		Button records = new Button("Records");
		Button loginp1 = new Button("Login");
		Button loginp2 = new Button("Login");
		Button rules = new Button("Time Limit");
		
		pass.setLayoutX(900);
		pass.setLayoutY(300);
		
		quit.setLayoutX(1057);
		quit.setLayoutY(300);
		
		records.setLayoutX(1042);
		records.setLayoutY(518);
		
		loginp1.setLayoutX(975);
		loginp1.setLayoutY(300);
		
		loginp2.setLayoutX(982);
		loginp2.setLayoutY(518);
		
		
		EventHandler<ActionEvent> whenPass = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				if(game.getGameBoard().mustPass())
				{
					if(game.getGameBoard().justPassed) //double pass
					{
						showResult();
					}
					else
					{
						game.getGameBoard().justPassed = true;
						game.getGameBoard().changeTurn();
						updateBoardPosition();
						if(othello.contains(P2Border))
						{
							othello.remove(P2Border);
							othello.add(P1Border);
							P1Border.toBack();
						}
						else
						{
							othello.remove(P1Border);
							othello.add(P2Border);
							P2Border.toBack();
						}
					}
				}
			}
		};
		
		EventHandler<ActionEvent> resignation = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				game.getGameBoard().resigned = true;
				rootPane.setOnMouseClicked(null);
				showResult();
			}
		};
		
		pass.setOnAction(whenPass);
		
		quit.setOnAction(resignation);
		
		othello.addAll(pass, quit, records, loginp1, loginp2);
		
		updateBoardPosition();
		
		Scene scene = new Scene(rootPane, 1200, 800);

		game.getStage().setTitle("Othello");
		game.getStage().setScene(scene);
		game.getStage().getIcons().add(new Image("file:icon.PNG"));
		game.getStage().show();
		
		rootPane.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				if(game.getGameBoard().timeUp) {
					rootPane.setOnMouseClicked(null);
					showResult();
				} else {
					rules.setDisable(true); //disable the rules button
					int r = ((int)event.getY()-128)/50;
					int c = ((int)event.getX()-150)/50;
					System.out.println(r+" "+c);
					if(!game.getGameBoard().isMoveValid(r, c))
					{
						return;
					}
					game.getGameBoard().justPassed = false;
					game.getGameBoard().placeDisc(r, c);
					
					if(blackTimer.isRunning() || whiteTimer.isRunning())
						blackTimer.startTimer();
						
					updateBoardPosition();
					if(othello.contains(P2Border))
					{
						othello.remove(P2Border);
						othello.add(P1Border);
						P1Border.toBack();
						
						//Stop player white timer.
						whiteTimer.stop();
						
						//Timer starts for player black
						blackTimer.startTimer();
					}
					else
					{
						othello.remove(P1Border);
						othello.add(P2Border);
						P2Border.toBack();
						
						//Stop black timer
						blackTimer.stop();
						
						//Timer starts for player white
						whiteTimer.startTimer();
					}
					int blackScore = game.getGameBoard().getBlackScore();
					int whiteScore = game.getGameBoard().getWhiteScore();
					P1S.setText(""+blackScore);
					if(blackScore > 9)
					{
						P1S.setLayoutX(640);
					}
					else
					{
						P1S.setLayoutX(645);
					}
					P2S.setText(""+whiteScore);
					if(whiteScore > 9)
					{
						P2S.setLayoutX(640);
					}
					else
					{
						P2S.setLayoutX(645);
					}
					if(blackScore+whiteScore == 64)
					{
						showResult();
					}
					double total = blackScore + whiteScore;
					
					double blackLevel = 420*blackScore/total;
					P1Score.setHeight(blackLevel);
					P1S.setLayoutY(blackLevel+98);
					
					double whiteLevel = 420*(1-whiteScore/total) + 118;
					P2Score.setY(whiteLevel);
					P2Score.setHeight(538-whiteLevel);
					P2S.setLayoutY(whiteLevel+30);
				}
			}
		});
	}

	/**
	 * 
	 */
	public void passTurn() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void quitGame() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void selectSpace() {
		// TODO implement here
	}


		
	public static Rectangle cellFinder(int x, int y)
	{
		for(Node n : othello)
		{
			if(n instanceof Rectangle)
			{
				Rectangle r = (Rectangle)n;
				if(r.getX() == 50*y + 150 && r.getY() == 50*x + 128)
				{
					othello.remove(n);
					return r;
				}
			}
		}
		return null;
	}
	
	public static void updateBoardPosition()
	{
		//remove all discs from the GUI, and forget all of them
		othello.removeAll(discs);
		discs.clear();
		
		//re-find every disc and potential move
		int[][] grid = game.getGameBoard().getBoard();
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				Rectangle r = cellFinder(i, j);
				r.setFill(Color.GREEN);
				if(grid[i][j] == 1 || grid[i][j] == 2)
				{
					Circle newDisc = new Circle(50*j + 175, 50*i + 153, 22);
					newDisc.setStroke(Color.BLACK);
					if(grid[i][j] == 1)
					{
						newDisc.setFill(Color.BLACK);
					}
					else
					{
						newDisc.setFill(Color.WHITE);
					}
					discs.add(newDisc);
				}
				if(grid[i][j] == 5)
				{
					r.setFill(Color.GOLD);
				}
				othello.add(r);
			}
		}
		
		//put them back in the GUI
		othello.addAll(discs);
	}
	
	public static void showResult()
	{
		Text endOfGame = new Text("");
		endOfGame.setLayoutX(240);
		endOfGame.setLayoutY(580);
		endOfGame.setFont(new Font("Arial Narrow", 24));
		endOfGame.setFill(Color.WHITE);
		
		String endText = game.getGameBoard().winner();
		if(game.getGameBoard().timeUp) {
			endOfGame.setText("Time is Up  -   Game Over.\n" + endText);
		}
		else if(!game.getGameBoard().resigned && game.getGameBoard().getWhiteScore() + game.getGameBoard().getBlackScore() < 64)
		{
			endOfGame.setText("Double Pass - Game Over.\n\t" + endText);
		}
		else
		{
			endOfGame.setText("     Game Over.\n" + endText);
		}
		othello.addAll(endOfGame);
	}
	

}
