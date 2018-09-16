package lab2;

import utils.ArrayUtils;

import java.util.ArrayList;

import static utils.ArrayUtils.OrderType;

import java.util.Arrays;

public class Task1 {

    private String[] strings;

    public Task1(String[] strings) {
        this.strings = Arrays.copyOf(strings, strings.length);
    }

    public Task1() {
        this(new String[0]);
    }

    public String longestString() {
        if (strings.length == 0)
            return null;
        String res = strings[0];
        for (String s : strings) {
            if (s.length() > res.length())
                res = s;
        }
        return res;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
