package application;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The UI for viewing player records. Shows a list of all players and their win, loss record 
 *
 * Author: Jason McElwee
 */
public class RecordsUI extends Application {

    private StackPane recordsPane = new StackPane();

    public void start(Stage recordsStage) {
        ArrayList<String> recordsList = Player.getPlayerRecords();

        VBox vBox = new VBox();
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < recordsList.size(); i++) {
            Label tempL = new Label(recordsList.get(i));
            tempL.setTextFill(Color.WHITE);
            vBox.getChildren().add(tempL);
        }

        Button exit = new Button("Close");

        vBox.getChildren().add(exit);
        recordsPane.getChildren().addAll(vBox);

        // gives button purpose
        exit.setOnAction(
            actionEvent -> {
                recordsStage.close();
            }
        );

        // starts the UI
        recordsPane.setStyle("-fx-background-color:#520100;");
        Scene loginScene = new Scene(recordsPane, 300, 200);
        recordsStage.setTitle("Login");
        recordsStage.setScene(loginScene);
        recordsStage.show();
        recordsStage.setAlwaysOnTop(true);
    }

    public void initializeUI(Stage recordsStage) {
        start(recordsStage);
    }
}
