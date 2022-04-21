// Main program for COMP1721 Coursework 1
// DO NOT CHANGE THIS!

package comp1721.cwk1;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Wordle extends Application{
  public void start(Stage primaryStage) throws Exception{
    /*Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
    primaryStage.setTitle("Wordle");
    primaryStage.setScene(new Scene(root));*/
    primaryStage.show();
  }

  public static void main(String[] args) throws IOException {
    launch(args);
    Game game;
    if (args.length > 1) {
      // Player wants to specify the game
      game = new Game(Integer.parseInt(args[1]), "data/words.txt");
      game.play();
    }else if(args.length == 1){
      if(args[0].equals("-a")){
        game = new Game("data/words.txt");
        game.accessiblePlay();
      }else{
        game = new Game(Integer.parseInt(args[0]),"data/words.txt");
        game.play();
      }
    } else {
      // Play today's game
      game = new Game("data/words.txt");
      game.play();
    }
    game.save("build/lastgame.txt");


  }
}

