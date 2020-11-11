package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RulesUI {
Stage primaryStage;
TextField textfield = new TextField();
Stage newWindow = new Stage();
GameTimer timer1;
GameTimer timer2;
	
	public RulesUI(Stage primaryStage, GameTimer timer1, GameTimer timer2) {
		this.primaryStage = primaryStage;
		this.timer1 = timer1;
		this.timer2 = timer2;
	}
	
	public void openUI() {
        Label titleLabel = new Label("Change the amount of time each player has in the game.");
	titleLabel.setTextFill(Color.WHITE);
        Label subLabel = new Label("Please input in seconds");
	subLabel.setTextFill(Color.WHITE);
        Button submit = new Button("Submit");
        submit.setOnAction(setTimer);
        
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(10, 10, 10, 10));
	vBox.setStyle("-fx-background-color:#520100;");
        vBox.getChildren().addAll(titleLabel, subLabel, textfield, submit);
   	 
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().addAll(vBox);

        Scene secondScene = new Scene(secondaryLayout, 400, 150);
        
        

        // New window (Stage)
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.show();
	}
	
	EventHandler<ActionEvent> setTimer = new EventHandler<ActionEvent>()
	{
		public void handle(ActionEvent e)
		{
			int seconds = Integer.parseInt(textfield.getText());
			//Need to scan textfield to make sure it contains only numbers
			
			timer1.setTimer(seconds);
			timer2.setTimer(seconds);
			
			newWindow.close();
		}
	};
}
