package comp1721.cwk1;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class WordList {
    List<String> words;
  // TODO: Implement constructor with a String parameter
    public WordList(String filename){
        this.words = new ArrayList<>();
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                words.add(tempString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  // TODO: Implement size() method, returning an int
    public int size(){
        return this.words.size();
    }
    // TODO: Implement getWord() with an int parameter, returning a String
    public String getWord(int n){
        int size = this.words.size();
        if (n<0 ||n> size){
            throw new GameException("Invalid number.");
        }
        return this.words.get(n);
    }
}
