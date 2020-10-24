package application;

import javafx.application.Application;
import java.util.*;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Scene;
import javax.swing.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);		
	}
	
	public void start(Stage primaryStage) {
		
		Pane rootPane = new Pane();
		rootPane.setStyle("-fx-background-color:#520100;");
		
		Button pass = new Button("Pass");
		Button quit = new Button("QUIT");
		pass.setLayoutX(900);
		pass.setLayoutY(300);
		
		quit.setLayoutX(1057);
		quit.setLayoutY(300);
		
		Rectangle P1 = new Rectangle(900,128,200,150);
		P1.setStroke(Color.BLACK);
		P1.setFill(Color.BLACK);
		
		Rectangle P1Border = new Rectangle(890,118,220,170);
		P1Border.setStroke(Color.YELLOW);
		P1Border.setFill(Color.YELLOW);
	
		Rectangle P2 = new Rectangle(900,348,200,150);
		P2.setStroke(Color.BLACK);
		P2.setFill(Color.WHITE);
		
		Rectangle P2Border = new Rectangle(890,338,220,170);
		P2Border.setStroke(Color.YELLOW);
		P2Border.setFill(Color.YELLOW);
		

		//TILES
		//TILE Nx1
		Rectangle boardTile1x1 = new Rectangle(150,128,50,50);
		boardTile1x1.setStroke(Color.BLACK);
		boardTile1x1.setFill(Color.GREEN);
		
		Rectangle boardTile2x1 = new Rectangle(200,128,50,50);
		boardTile2x1.setStroke(Color.BLACK);
		boardTile2x1.setFill(Color.GREEN);
		
		Rectangle boardTile3x1 = new Rectangle(250,128,50,50);
		boardTile3x1.setStroke(Color.BLACK);
		boardTile3x1.setFill(Color.GREEN);
		
		Rectangle boardTile4x1 = new Rectangle(300,128,50,50);
		boardTile4x1.setStroke(Color.BLACK);
		boardTile4x1.setFill(Color.GREEN);
		
		Rectangle boardTile5x1 = new Rectangle(350,128,50,50);
		boardTile5x1.setStroke(Color.BLACK);
		boardTile5x1.setFill(Color.GREEN);
		
		Rectangle boardTile6x1 = new Rectangle(400,128,50,50);
		boardTile6x1.setStroke(Color.BLACK);
		boardTile6x1.setFill(Color.GREEN);
		
		Rectangle boardTile7x1 = new Rectangle(450,128,50,50);
		boardTile7x1.setStroke(Color.BLACK);
		boardTile7x1.setFill(Color.GREEN);
		
		Rectangle boardTile8x1 = new Rectangle(500,128,50,50);
		boardTile8x1.setStroke(Color.BLACK);
		boardTile8x1.setFill(Color.GREEN);
		
		//TILE Nx2
		Rectangle boardTile1x2 = new Rectangle(150,178,50,50);
		boardTile1x2.setStroke(Color.BLACK);
		boardTile1x2.setFill(Color.GREEN);
		
		Rectangle boardTile2x2 = new Rectangle(200,178,50,50);
		boardTile2x2.setStroke(Color.BLACK);
		boardTile2x2.setFill(Color.GREEN);
		
		Rectangle boardTile3x2 = new Rectangle(250,178,50,50);
		boardTile3x2.setStroke(Color.BLACK);
		boardTile3x2.setFill(Color.GREEN);
		
		Rectangle boardTile4x2 = new Rectangle(300,178,50,50);
		boardTile4x2.setStroke(Color.BLACK);
		boardTile4x2.setFill(Color.GREEN);
		
		Rectangle boardTile5x2 = new Rectangle(350,178,50,50);
		boardTile5x2.setStroke(Color.BLACK);
		boardTile5x2.setFill(Color.GREEN);
		
		Rectangle boardTile6x2 = new Rectangle(400,178,50,50);
		boardTile6x2.setStroke(Color.BLACK);
		boardTile6x2.setFill(Color.GREEN);
		
		Rectangle boardTile7x2 = new Rectangle(450,178,50,50);
		boardTile7x2.setStroke(Color.BLACK);
		boardTile7x2.setFill(Color.GREEN);
		
		Rectangle boardTile8x2 = new Rectangle(500,178,50,50);
		boardTile8x2.setStroke(Color.BLACK);
		boardTile8x2.setFill(Color.GREEN);
		
		//TILE Nx3
		Rectangle boardTile1x3 = new Rectangle(150,228,50,50);
		boardTile1x3.setStroke(Color.BLACK);
		boardTile1x3.setFill(Color.GREEN);
		
		Rectangle boardTile2x3 = new Rectangle(200,228,50,50);
		boardTile2x3.setStroke(Color.BLACK);
		boardTile2x3.setFill(Color.GREEN);
		
		Rectangle boardTile3x3 = new Rectangle(250,228,50,50);
		boardTile3x3.setStroke(Color.BLACK);
		boardTile3x3.setFill(Color.GREEN);
		
		Rectangle boardTile4x3 = new Rectangle(300,228,50,50);
		boardTile4x3.setStroke(Color.BLACK);
		boardTile4x3.setFill(Color.GREEN);
		
		Rectangle boardTile5x3 = new Rectangle(350,228,50,50);
		boardTile5x3.setStroke(Color.BLACK);
		boardTile5x3.setFill(Color.GREEN);
		
		Rectangle boardTile6x3 = new Rectangle(400,228,50,50);
		boardTile6x3.setStroke(Color.BLACK);
		boardTile6x3.setFill(Color.GREEN);
		
		Rectangle boardTile7x3 = new Rectangle(450,228,50,50);
		boardTile7x3.setStroke(Color.BLACK);
		boardTile7x3.setFill(Color.GREEN);
		
		Rectangle boardTile8x3 = new Rectangle(500,228,50,50);
		boardTile8x3.setStroke(Color.BLACK);
		boardTile8x3.setFill(Color.GREEN);
		
		//TILE Nx4
		Rectangle boardTile1x4 = new Rectangle(150,278,50,50);
		boardTile1x4.setStroke(Color.BLACK);
		boardTile1x4.setFill(Color.GREEN);
		
		Rectangle boardTile2x4 = new Rectangle(200,278,50,50);
		boardTile2x4.setStroke(Color.BLACK);
		boardTile2x4.setFill(Color.GREEN);
		
		Rectangle boardTile3x4 = new Rectangle(250,278,50,50);
		boardTile3x4.setStroke(Color.BLACK);
		boardTile3x4.setFill(Color.GREEN);
		
		Rectangle boardTile4x4 = new Rectangle(300,278,50,50);
		boardTile4x4.setStroke(Color.BLACK);
		boardTile4x4.setFill(Color.GREEN);
		
		Rectangle boardTile5x4 = new Rectangle(350,278,50,50);
		boardTile5x4.setStroke(Color.BLACK);
		boardTile5x4.setFill(Color.GREEN);
		
		Rectangle boardTile6x4 = new Rectangle(400,278,50,50);
		boardTile6x4.setStroke(Color.BLACK);
		boardTile6x4.setFill(Color.GREEN);
		
		Rectangle boardTile7x4 = new Rectangle(450,278,50,50);
		boardTile7x4.setStroke(Color.BLACK);
		boardTile7x4.setFill(Color.GREEN);
		
		Rectangle boardTile8x4 = new Rectangle(500,278,50,50);
		boardTile8x4.setStroke(Color.BLACK);
		boardTile8x4.setFill(Color.GREEN);
		
		//TILE Nx5
		Rectangle boardTile1x5 = new Rectangle(150,328,50,50);
		boardTile1x5.setStroke(Color.BLACK);
		boardTile1x5.setFill(Color.GREEN);
		
		Rectangle boardTile2x5 = new Rectangle(200,328,50,50);
		boardTile2x5.setStroke(Color.BLACK);
		boardTile2x5.setFill(Color.GREEN);
		
		Rectangle boardTile3x5 = new Rectangle(250,328,50,50);
		boardTile3x5.setStroke(Color.BLACK);
		boardTile3x5.setFill(Color.GREEN);
		
		Rectangle boardTile4x5 = new Rectangle(300,328,50,50);
		boardTile4x5.setStroke(Color.BLACK);
		boardTile4x5.setFill(Color.GREEN);
		
		Rectangle boardTile5x5 = new Rectangle(350,328,50,50);
		boardTile5x5.setStroke(Color.BLACK);
		boardTile5x5.setFill(Color.GREEN);
		
		Rectangle boardTile6x5 = new Rectangle(400,328,50,50);
		boardTile6x5.setStroke(Color.BLACK);
		boardTile6x5.setFill(Color.GREEN);
		
		Rectangle boardTile7x5 = new Rectangle(450,328,50,50);
		boardTile7x5.setStroke(Color.BLACK);
		boardTile7x5.setFill(Color.GREEN);
		
		Rectangle boardTile8x5 = new Rectangle(500,328,50,50);
		boardTile8x5.setStroke(Color.BLACK);
		boardTile8x5.setFill(Color.GREEN);
		
		//TILE Nx6
		Rectangle boardTile1x6 = new Rectangle(150,378,50,50);
		boardTile1x6.setStroke(Color.BLACK);
		boardTile1x6.setFill(Color.GREEN);
		
		Rectangle boardTile2x6 = new Rectangle(200,378,50,50);
		boardTile2x6.setStroke(Color.BLACK);
		boardTile2x6.setFill(Color.GREEN);
		
		Rectangle boardTile3x6 = new Rectangle(250,378,50,50);
		boardTile3x6.setStroke(Color.BLACK);
		boardTile3x6.setFill(Color.GREEN);
		
		Rectangle boardTile4x6 = new Rectangle(300,378,50,50);
		boardTile4x6.setStroke(Color.BLACK);
		boardTile4x6.setFill(Color.GREEN);
		
		Rectangle boardTile5x6 = new Rectangle(350,378,50,50);
		boardTile5x6.setStroke(Color.BLACK);
		boardTile5x6.setFill(Color.GREEN);
		
		Rectangle boardTile6x6 = new Rectangle(400,378,50,50);
		boardTile6x6.setStroke(Color.BLACK);
		boardTile6x6.setFill(Color.GREEN);
		
		Rectangle boardTile7x6 = new Rectangle(450,378,50,50);
		boardTile7x6.setStroke(Color.BLACK);
		boardTile7x6.setFill(Color.GREEN);
		
		Rectangle boardTile8x6 = new Rectangle(500,378,50,50);
		boardTile8x6.setStroke(Color.BLACK);
		boardTile8x6.setFill(Color.GREEN);
		
		//TILE Nx7
		Rectangle boardTile1x7 = new Rectangle(150,428,50,50);
		boardTile1x7.setStroke(Color.BLACK);
		boardTile1x7.setFill(Color.GREEN);
		
		Rectangle boardTile2x7 = new Rectangle(200,428,50,50);
		boardTile2x7.setStroke(Color.BLACK);
		boardTile2x7.setFill(Color.GREEN);
		
		Rectangle boardTile3x7 = new Rectangle(250,428,50,50);
		boardTile3x7.setStroke(Color.BLACK);
		boardTile3x7.setFill(Color.GREEN);
		
		Rectangle boardTile4x7 = new Rectangle(300,428,50,50);
		boardTile4x7.setStroke(Color.BLACK);
		boardTile4x7.setFill(Color.GREEN);
		
		Rectangle boardTile5x7 = new Rectangle(350,428,50,50);
		boardTile5x7.setStroke(Color.BLACK);
		boardTile5x7.setFill(Color.GREEN);
		
		Rectangle boardTile6x7 = new Rectangle(400,428,50,50);
		boardTile6x7.setStroke(Color.BLACK);
		boardTile6x7.setFill(Color.GREEN);
		
		Rectangle boardTile7x7 = new Rectangle(450,428,50,50);
		boardTile7x7.setStroke(Color.BLACK);
		boardTile7x7.setFill(Color.GREEN);
		
		Rectangle boardTile8x7 = new Rectangle(500,428,50,50);
		boardTile8x7.setStroke(Color.BLACK);
		boardTile8x7.setFill(Color.GREEN);
		
		//TILE Nx8
		Rectangle boardTile1x8 = new Rectangle(150,478,50,50);
		boardTile1x8.setStroke(Color.BLACK);
		boardTile1x8.setFill(Color.GREEN);
		
		Rectangle boardTile2x8 = new Rectangle(200,478,50,50);
		boardTile2x8.setStroke(Color.BLACK);
		boardTile2x8.setFill(Color.GREEN);
		
		Rectangle boardTile3x8 = new Rectangle(250,478,50,50);
		boardTile3x8.setStroke(Color.BLACK);
		boardTile3x8.setFill(Color.GREEN);
		
		Rectangle boardTile4x8 = new Rectangle(300,478,50,50);
		boardTile4x8.setStroke(Color.BLACK);
		boardTile4x8.setFill(Color.GREEN);
		
		Rectangle boardTile5x8 = new Rectangle(350,478,50,50);
		boardTile5x8.setStroke(Color.BLACK);
		boardTile5x8.setFill(Color.GREEN);
		
		Rectangle boardTile6x8 = new Rectangle(400,478,50,50);
		boardTile6x8.setStroke(Color.BLACK);
		boardTile6x8.setFill(Color.GREEN);
		
		Rectangle boardTile7x8 = new Rectangle(450,478,50,50);
		boardTile7x8.setStroke(Color.BLACK);
		boardTile7x8.setFill(Color.GREEN);
		
		Rectangle boardTile8x8 = new Rectangle(500,478,50,50);
		boardTile8x8.setStroke(Color.BLACK);
		boardTile8x8.setFill(Color.GREEN);
		//TILES END
		
		
		//CHIPS
		//CHIPSNx1
		Circle chip4x4 = new Circle(325,303,22);
		chip4x4.setStroke(Color.BLACK);
		chip4x4.setFill(Color.WHITE);
		
		Circle chip5x4 = new Circle(375,353,22);
		chip5x4.setStroke(Color.BLACK);
		chip5x4.setFill(Color.WHITE);
		
		Circle chip4x5 = new Circle(325,353,22);
		chip4x5.setStroke(Color.BLACK);
		chip4x5.setFill(Color.BLACK);
		
		Circle chip5x5 = new Circle(375,303,22);
		chip5x5.setStroke(Color.BLACK);
		chip5x5.setFill(Color.BLACK);
		
		
		Rectangle boardBorder = new Rectangle(140,118,420,420);
		boardBorder.setStroke(Color.BLACK);
		boardBorder.setFill(Color.BLACK);	
		
		Rectangle P1Score = new Rectangle(600,118,100,210);
		P1Score.setStroke(Color.BLACK);
		P1Score.setFill(Color.BLACK);
		
		Rectangle P2Score = new Rectangle(600,328,100,210);
		P2Score.setStroke(Color.BLACK);
		P2Score.setFill(Color.WHITE);
		
		TextField P1Name = new TextField("Player 1");
		P1Name.setLayoutX(924);
		P1Name.setLayoutY(160);
		
		TextField P1Timer = new TextField("1:30");
		P1Timer.setLayoutX(924);
		P1Timer.setLayoutY(220);
		
		TextField P2Name = new TextField("Player 2");
		P2Name.setLayoutX(924);
		P2Name.setLayoutY(380);
		
		TextField P2Timer = new TextField("1:30");
		P2Timer.setLayoutX(924);
		P2Timer.setLayoutY(440);
		
		Text P1S = new Text("2");
		P1S.setLayoutX(650);
		P1S.setLayoutY(308);
		P1S.setFill(Color.WHITE);
		
		Text P2S = new Text("2");
		P2S.setLayoutX(650);
		P2S.setLayoutY(518);
		
		rootPane.getChildren().addAll(boardBorder,boardTile1x1,boardTile2x1,boardTile3x1,boardTile4x1,boardTile5x1,boardTile6x1,boardTile7x1,boardTile8x1,
									  boardTile1x2,boardTile2x2,boardTile3x2,boardTile4x2,boardTile5x2,boardTile6x2,boardTile7x2,boardTile8x2,
									  boardTile1x3,boardTile2x3,boardTile3x3,boardTile4x3,boardTile5x3,boardTile6x3,boardTile7x3,boardTile8x3,
									  boardTile1x4,boardTile2x4,boardTile3x4,boardTile4x4,boardTile5x4,boardTile6x4,boardTile7x4,boardTile8x4,
									  boardTile1x5,boardTile2x5,boardTile3x5,boardTile4x5,boardTile5x5,boardTile6x5,boardTile7x5,boardTile8x5,
									  boardTile1x6,boardTile2x6,boardTile3x6,boardTile4x6,boardTile5x6,boardTile6x6,boardTile7x6,boardTile8x6,
									  boardTile1x7,boardTile2x7,boardTile3x7,boardTile4x7,boardTile5x7,boardTile6x7,boardTile7x7,boardTile8x7,
									  boardTile1x8,boardTile2x8,boardTile3x8,boardTile4x8,boardTile5x8,boardTile6x8,boardTile7x8,boardTile8x8,
									  chip4x4,chip5x4,chip4x5,chip5x5,
									  P1Border,P1,P2Border,P2,pass,quit,P1Score,P2Score,P1S,P2S,P1Name,P1Timer,P2Name,P2Timer);
	
		Scene scene = new Scene(rootPane, 1200, 800);

		primaryStage.setTitle("OthelloV4");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
