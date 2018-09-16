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

    public String[] orderByLength(OrderType orderType) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (orderType == OrderType.ASC) {
                    if (strings[i].length() > strings[j].length()) {
                        ArrayUtils.swap(strings, i, j);
                    }
                } else if (orderType == OrderType.DESC) {
                    if (strings[i].length() < strings[j].length()) {
                        ArrayUtils.swap(strings, i, j);
                    }
                }
            }
        }
        return this.getStrings();
    }

    public int[] getLengths() {
        int[] lengthsArray = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            lengthsArray[i] = strings[i].length();
        }
        return lengthsArray;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
