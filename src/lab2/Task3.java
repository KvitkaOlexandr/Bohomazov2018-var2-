package lab2;

public class Task3 {

    private String text;

    public Task3(String text) {
        this.text = text;
    }

    public Task3() {
        this("");
    }

    public String stuff() {
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < text.length() - 1; i++) {
            if (!Character.isSpaceChar(text.charAt(i + 1)) && Character.toLowerCase(text.charAt(i)) == 'р') {
                if (text.charAt(i + 1) == 'а')
                    sb.setCharAt(i + 1, 'о');
            }
        }
        text = sb.toString();
        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
