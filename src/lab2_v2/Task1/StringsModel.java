package lab2_v2.Task1;

public class StringsModel {
    private String[] strings;
    private int currentPosition;

    public StringsModel(int size) {
        strings = new String[size];
        currentPosition = 0;
    }

    public StringsModel(String[] strings) {
        this.strings = strings;
        currentPosition = 0;
    }

    public String[] getStrings() {
        String[] result = new String[strings.length];
        System.arraycopy(strings, 0, result, 0, strings.length);
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

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
