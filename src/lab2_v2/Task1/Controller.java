package lab2_v2.Task1;

import java.util.Arrays;

public class Controller {


    private StringsModel model;

    public Controller(StringsModel model) {
        this.model = model;
    }

    public void addString(String line) {
        int currentPosition = model.getCurrentPosition();
        String[] strings = this.model.getStrings();
        strings[currentPosition] = line;
        currentPosition++;
        if (currentPosition == strings.length) {
            String[] newStrings = new String[strings.length + 10];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            this.model.setStrings(newStrings);
            this.model.setCurrentPosition(currentPosition);
        }
    }

    public void deleteString(int position) {
        int currentPosition = model.getCurrentPosition();
        if (currentPosition - position >= 0)
            System.arraycopy(model, position + 1, model, position, currentPosition - position);
        currentPosition--;
        this.model.setCurrentPosition(currentPosition);
    }

    public String longestString() {
        int currentPosition = model.getCurrentPosition();
        String[] strings = this.model.getStrings();

        if (strings.length == 0)
            throw new IllegalArgumentException();
        String result = strings[0];
        for (int i = 0; i < currentPosition; i++) {
            if (strings[i].length() > result.length())
                result = strings[i];
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.model.getCurrentPosition(); i++) {
            result.append(" ").append(this.model.getStrings()[i]);
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.model.getStrings());
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
        Controller other = (Controller) obj;
        return Arrays.equals(model.getStrings(), other.model.getStrings());
    }

}
