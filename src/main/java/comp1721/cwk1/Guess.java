package comp1721.cwk1;


import java.util.Scanner;


public class Guess {
  int guessNumber;
  String chosenWord;
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  // TODO: Implement constructor with int parameter
  public Guess(int guessNumber) throws GameException{
    if(guessNumber < 1 || guessNumber > 6){
      throw new GameException("");
    }else {
      this.guessNumber = guessNumber;
      readFromPlayer();
    }
  }
  // TODO: Implement constructor with int and String parameters
  public Guess(int guessNumber, String chosenWord){
    if(guessNumber < 1 || guessNumber > 6){
      throw new GameException("");
    }else{
      if(chosenWord.length() != 5){
        throw new GameException("");
      }else{
        for(int i = 0; i < 5; i++){
          char a = chosenWord.charAt(i);
          if(!((a > 64 && a < 91) || (a > 96 && a < 123))){
            throw new GameException("");
          }
        }
        this.guessNumber = guessNumber;
        this.chosenWord = chosenWord.toUpperCase();
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
    int i, j;
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
    int i, j;
    int correct = 0;
    int dirWrong = 0;
    String[] number = {"1st", "2nd", "3rd", "4th", "5th"};
    StringBuilder tar = new StringBuilder(target);
    StringBuilder res = new StringBuilder();
    for (i = 0; i < this.chosenWord.length(); i++){
      for (j = 0; j < target.length(); j++){
        if(this.chosenWord.charAt(i) == tar.charAt(j)) {
          if (i == j) {
            correct++;
          } else {
            dirWrong++;
          }
          tar.setCharAt(j,'0');
          break;
        }
      }
    }
    for(i = 0; i < dirWrong; i++){
      if(i < dirWrong - 1){
        res.append(number[i]).append(", ");
      }else{
        res.append(number[i]).append(" ");
      }
    }
    res.append("correct but in wrong place, ");
    for(i = 0; i < correct; i++){
      if(i < correct - 1){
        res.append(number[i]).append(", ");
      }else{
        res.append(number[i]).append(" ");
      }
    }
    res.append("perfect");
    return res.toString();
  }
}
