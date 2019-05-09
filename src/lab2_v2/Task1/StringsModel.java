package lab2_v2.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringsModel implements Observable {

    private String[] strings;
    private int currentPosition;
    private List<Observer> observers;

    public StringsModel(int size) {
        strings = new String[size];
        observers = new ArrayList<>();
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
        notifyObservers();
    }

    public void deleteString(int position) {
        if (currentPosition - position >= 0)
            System.arraycopy(strings, position + 1, strings, position, currentPosition - position);
        currentPosition--;
        notifyObservers();
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
        notifyObservers();
    }

    public void setString(String string, int pos) {
        strings[pos] = string;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers)
            o.update(this);
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
        StringsModel other = (StringsModel) obj;
        return Arrays.equals(strings, other.strings);
    }
}