package lab2;

import java.util.HashMap;
import java.util.Map;

public class Task4 {

    private String text;

    public Task4(String text) {
        this.text = text;
    }

    public Task4() {
        this("");
    }

    public Map<String, Integer> wordFreqs() {
        String[] words = text.split("\\P{L}");
        Map<String, Integer> dict = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                Integer previousCount;
                if (dict.containsKey(w))
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
