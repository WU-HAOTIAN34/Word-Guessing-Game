package comp1721.cwk1;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("data/game.fxml"));
        primaryStage.setTitle("Wordle");
        primaryStage.setScene(new Scene(root));*/
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}