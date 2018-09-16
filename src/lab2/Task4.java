package lab2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task4 {

    private String text;

    public Task4(String text) {
        this.text = text;
    }

    public Task4() {
        this("");
    }

    public Hashtable<String, Integer> wordFreqs() {
        String[] words = text.split("\\P{L}");
        Hashtable<String, Integer> dict = new Hashtable<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                Integer previousCount;
                if(dict.containsKey(w))
                    previousCount = dict.get(w) + 1;
                else
                    previousCount = 1;
                dict.put(w, previousCount);
            }
        }
        return dict;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
