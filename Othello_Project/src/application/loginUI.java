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

public class loginUI extends Application{
	
	private StackPane loginPane = new StackPane();
	
    private Stage stage;
	
	public void init() {
        Button button = new Button("OPEN");
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        Label username = new Label("Username");
        username.setTextFill(Color.WHITE);
        Label password = new Label("Password");
        password.setTextFill(Color.WHITE);
        vBox.getChildren().addAll(
                username,
                new TextField(),
                password,
                new PasswordField(),
                new Button("LOGIN"));
        loginPane.getChildren().addAll(vBox);

        button.setOnAction(actionEvent-> {
            if(stage!=null){
                stage.requestFocus();
                return;
            }
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });
    }
	
	
	public void start(Stage loginStage) {
		
		loginPane.setStyle("-fx-background-color:#520100;");
		Scene loginScene = new Scene(loginPane,300,200);
		loginStage.setTitle("Login");
		loginStage.setScene(loginScene);
		loginStage.show();
		loginStage.setAlwaysOnTop(true);
	}
	
	
	
	public static void main(String[] args) {
		launch(args);		
	}
}
