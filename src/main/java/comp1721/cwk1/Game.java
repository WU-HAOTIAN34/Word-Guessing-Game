package comp1721.cwk1;


import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int gameNumber;
    String target;
    List<String> result;
  // TODO: Implement constructor with String parameter
    public Game(String filename) throws IOException{
        WordList begin = new WordList(filename);
        LocalDate first =  LocalDate.of(2022, 2, 10);
        LocalDate now = LocalDate.now();
        Period next = Period.between(first, now);
        this.gameNumber = next.getDays();
        this.target = begin.getWord(this.gameNumber);

    }

  // TODO: Implement constructor with int and String parameters
    public Game(int gameNumber, String filename) throws IOException, GameException{
        WordList begin = new WordList(filename);
        this.gameNumber = gameNumber;
        this.target = begin.getWord(gameNumber);

    }

  // TODO: Implement play() method
    public void play() throws IOException{
        int i;
        String result;
        this.result = new ArrayList<>();
        for(i = 0; i < 6; i++){
            int num = i + 1;
            System.out.printf("Enter guess (%d/6): ", num);
            Guess loop = new Guess(num);
            result = loop.compareWith(this.target);
            this.result.add(result);
            System.out.println(result);

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
        System.out.println("\n--------------------\nHistory:\n");
        printHistory(i);

    }

    public void printHistory(int num) throws IOException{
        int winGame = 0;
        int[] number = new int[9];
        String history = readHistory("data/history.txt");

        String[] arr = history.split(" ");
        // 9 numbers in the history.txt: 1-6 winning numbers 1 times ... 6 times
        // 7: the total game numbers, 8: the longest winning streak, 9: current winning streak
        for(int i = 0; i < 9; i++){
            number[i] = Integer.parseInt(arr[i]);
        }
        if(num < 6){
            number[6] += 1;
            number[8] += 1;
            number[num] += 1;
        }else{
            number[8] = 0;
        }
        if(number[8] >= number[7]){
            number[7] = number[8];
        }
        for(int i = 0; i < 6; i++){
            winGame += number[i];
        }
        for(num = 0; num < 6; num++){
            System.out.printf("%d times: ", num + 1);
            for(int j = 0; j < number[num]; j++){
                System.out.print("*");
            }
            System.out.printf(" %d\n", number[num]);
        }
        System.out.printf("\nThe numbers of games played: %d\n", number[num]);
        System.out.printf("The percentage of games that were wins: %f\n", (double)winGame / (double)number[6]);
        num++;
        System.out.printf("The length of the current winning streak: %d\n", number[num]);
        num++;
        System.out.printf("The longest winning streak: %d\n", number[num]);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 9; i++){
            res.append(number[i]);
            if(i == 8){
                break;
            }
            res.append(" ");
        }
        File f = new File("data/history.txt");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(res);
        pw.close();
    }



  // TODO: Implement save() method, with a String parameter
    public void save(String filename) throws IOException{
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        for (String s : this.result) {
            pw.println(s);
        }
        pw.close();
    }
    // TODO: read the history.txt
    public String readHistory(String filename) throws IOException{
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String tempString;
        tempString = reader.readLine();
        fr.close();
        return tempString;
    }

    public void accessiblePlay() throws  IOException{
        int i;
        String result;
        this.result = new ArrayList<>();
        for(i = 0; i < 6; i++){
            int num = i + 1;
            System.out.printf("Enter guess (%d/6): ", num);
            Guess loop = new Guess(num);
            result = loop.accessibleCompare(this.target);
            System.out.println(result);
            this.result.add(result);
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
        printHistory(i);
    }
}
