package lab2;

public class Task5 {
    private String string;

    public Task5(String string) {
        this.string = string;
    }

    public Task5() {
        this("");
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < string.length(); i++)
            sb.setCharAt(string.length() - 1 - i, string.charAt(i));
        return sb.toString();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }


}
