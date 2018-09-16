package lab2;

import javafx.util.Pair;

import java.util.ArrayList;
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

    private char getBiggestChar() {
        char max = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > max) {
                max = text.charAt(i);
            }
        }
        return max;
    }

    public Object[] orderCharsByFrequency() {
        int[] freqs = new int[getBiggestChar() + 1];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    freqs[text.charAt(i)]++;
                }
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < freqs.length; i++) {
            int maxFreq = 0;
            int maxIndex = 0;
            for (int j = 0; j < freqs.length; j++) {
                if (freqs[j] > maxFreq) {
                    maxFreq = freqs[j];
                    maxIndex = j;
                }
            }/**/
            if (maxFreq != 0)
                list.add((char) maxIndex);
            freqs[maxIndex] = 0;
        }
        return list.toArray();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
