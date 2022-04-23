package comp1721.cwk1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Guess {
  private final int guessNumber;
  private String chosenWord;
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  // TODO: Implement constructor with int parameter
  public Guess(int guessNumber1) throws GameException{
    if(guessNumber1 < 1 || guessNumber1 > 6){
      throw new GameException("");
    }else {
      this.guessNumber = guessNumber1;
      readFromPlayer();
    }
  }
  // TODO: Implement constructor with int and String parameters
  public Guess(int guessNumber1, String chosenWord1){
    if(guessNumber1 < 1 || guessNumber1 > 6){
      throw new GameException("");
    }else{
      if(chosenWord1.length() != 5){
        throw new GameException("");
      }else{
        for(int i = 0; i < 5; i++){
          char a = chosenWord1.charAt(i);
          if(!((a > 64 && a < 91) || (a > 96 && a < 123))){
            throw new GameException("");
          }
        }
        this.guessNumber = guessNumber1;
        this.chosenWord = chosenWord1.toUpperCase();
      }
    }
  }
  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){
    return this.guessNumber;
  }
  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){
    return this.chosenWord;
  }
  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){
    String res = INPUT.nextLine();
    if(res.length() != 5){
      throw new GameException("");
    }else{
      this.chosenWord = res.toUpperCase();
    }
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){
    int i;
    int j;
    StringBuilder tar = new StringBuilder(target);
    StringBuilder res = new StringBuilder();
    for (i = 0; i < this.chosenWord.length(); i++){
      for (j = 0; j < target.length(); j++){
        if(this.chosenWord.charAt(i) == tar.charAt(j)) {
          if (i == j) {
            res.append("\033[30;102m ").append(this.chosenWord.charAt(i)).append(" \033[0m");
          } else {
            res.append("\033[30;103m ").append(this.chosenWord.charAt(i)).append(" \033[0m");
          }
          tar.setCharAt(j,'0');
          break;
        }
      }
      if (j == this.chosenWord.length()) {
        res.append("\033[30;107m ").append(this.chosenWord.charAt(i)).append(" \033[0m");
      }
    }
    return res.toString();
  }
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){
    return target.equalsIgnoreCase(this.chosenWord);
  }
  //  TODO: compareWith() method for accessible
  public String accessibleCompare(String target){
    int i;
    int j;
    List<String> correct = new ArrayList<>();
    List<String> dirWrong = new ArrayList<>();
    //get the number of letters
    String[] number = {"1st", "2nd", "3rd", "4th", "5th"};
    StringBuilder tar = new StringBuilder(target);
    StringBuilder res = new StringBuilder();
    for (i = 0; i < this.chosenWord.length(); i++){
      for (j = 0; j < target.length(); j++){
        if(this.chosenWord.charAt(i) == tar.charAt(j)) {
          if (i == j) {
            correct.add(number[i]);
          } else {
            dirWrong.add(number[i]);
          }
          tar.setCharAt(j,'0');
          break;
        }
      }
    }
    // consist the String
    for(i = 0; i < dirWrong.size(); i++){
      if(i < dirWrong.size() - 1){
        res.append(dirWrong.get(i)).append(", ");
      }else{
        res.append(dirWrong.get(i)).append(" ");
      }
    }
    //no letters grt wrong direction
    if(dirWrong.size() != 0){
      res.append("correct but in wrong place ");
    }
    //if five letters all correct, win
    if(correct.size() == 5){
      res.append("You won!");
    }else{
      for(i = 0; i < correct.size(); i++){
        if(i < correct.size() - 1){
          res.append(correct.get(i)).append(". ");
        }else{
          res.append(correct.get(i)).append(" ");
        }
      }
      // no letters correct
      if(correct.size() != 0){
        res.append("perfect!");
      }
    }
    return res.toString();
  }
}
