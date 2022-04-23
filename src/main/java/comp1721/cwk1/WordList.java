package comp1721.cwk1;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class WordList {
    private final List<String> words;
    // TODO: Implement constructor with a String parameter
    public WordList(String filename) throws IOException{
        this.words = new ArrayList<>();
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String tempString;
        while ((tempString = reader.readLine()) != null) {
            words.add(tempString);
        }
        fr.close();
    }
    // TODO: Implement size() method, returning an int
    public int size(){
        return this.words.size();
    }
    // TODO: Implement getWord() with an int parameter, returning a String
    public String getWord(int n){
        int size = this.words.size();
        if (n < 0 || n > size - 1){
            throw new GameException("");
        }else {
            return this.words.get(n);
        }
    }
}
