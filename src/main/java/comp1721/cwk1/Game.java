package comp1721.cwk1;


import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Game {
    int gameNumber;
    String target;
  // TODO: Implement constructor with String parameter
    public Game(String filename){
        WordList begin = new WordList(filename);

    }
  // TODO: Implement constructor with int and String parameters
    public Game(int gameNumber, String filename){
        WordList begin = new WordList(filename);
        this.gameNumber = gameNumber;
        this.target = begin.getWord(gameNumber);
    }
  // TODO: Implement play() method
    public void play(){
        int i;
        for(i = 0; i < 6; i++){
            int num = i + 1;
            System.out.printf("Enter guess (%d/6): ", num);
            Guess loop = new Guess(num);
            System.out.println(loop.compareWith(this.target));
            if(loop.matches(this.target)){
                break;
            }
        }
        if(i == 0){
            System.out.println("Superb - Got it in one!");
        }else if(i > 0 && i < 5){
            System.out.println("Well done!");
        }else if(i == 5){
            System.out.println("That was a close call!");
        }
    }
    
  // TODO: Implement save() method, with a String parameter
    public void save(String filename){

        String fileName="F:\\IDEA_Codes\\WriteTextFiles\\src\\f.txt";

        FileWriter fw=null;
        PrintWriter toFile=null;

        try{
            fw=new FileWriter(fileName,true);
            toFile=new PrintWriter(fw);

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("PrintWriter error opening the file:"+fileName);
            System.exit(0);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("FileWriter error opening the file:"+fileName);
            System.exit(0);
        }
        System.out.println("Please input four additional lines of text:");


        for(int count=1;count<=4;count++){

            toFile.println("Translation "+count+": ");
        }

        System.out.println("Four lines were written to "+fileName);
        toFile.close();





    }
}
