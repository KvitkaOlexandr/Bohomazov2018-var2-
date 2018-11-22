package lab2;

import java.util.Arrays;


public class Task1 {

    private String[] strings;
    private int currentPosition;

    public Task1(int size) {
        strings = new String[size];
        currentPosition = 0;
    }

    public void addString(String line) {
        strings[currentPosition] = line;
        currentPosition++;
        if (currentPosition == strings.length) {
            String[] newStrings = new String[strings.length + 10];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            strings = newStrings;
        }
    }

    public void deleteString(int position) {
        if (currentPosition - position >= 0)
            System.arraycopy(strings, position + 1, strings, position, currentPosition - position);
        currentPosition--;
    }

    public String longestString() {
        if (strings.length == 0)
            throw new IllegalArgumentException();
        String result = strings[0];
        for (int i = 0; i < currentPosition; i++) {
            if (strings[i].length() > result.length())
                result = strings[i];
        }
        return result;
    }

    public String[] getStrings() {
        String[] result = new String[currentPosition];
        System.arraycopy(strings, 0, result, 0, currentPosition);
        return result;
    }

    public void setStrings(String[] newStrings) {
        strings = new String[newStrings.length];
        for (int i = 0; i < newStrings.length; i++) {
            setString(newStrings[i], i);
        }
    }

    public void setString(String string, int pos) {
        strings[pos] = string;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            result.append(" ").append(strings[i]);
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(strings);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task1 other = (Task1) obj;
        return Arrays.equals(strings, other.strings);
    }
}