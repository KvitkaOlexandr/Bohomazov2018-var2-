package lab2;

public class Task3 {

    private String text;

    public Task3(String text) {
        this.text = text;
    }

    public Task3() {
        this("");
    }

    public String addTwoWhitespacesBetweenLetters() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i < text.length() - 1 && Character.isAlphabetic(text.charAt(i)) && Character.isAlphabetic(text.charAt(i + 1)))
                sb.append("  ");
        }
        return sb.toString();
    }

    public String replaceCharsWithCode() {
        StringBuilder sb = new StringBuilder();
        String spacedText = addTwoWhitespacesBetweenLetters();
        for (int i = 0; i < spacedText.length(); i++) {
            if (Character.isAlphabetic(spacedText.charAt(i)))
                sb.append(Character.toUpperCase(spacedText.charAt(i)) - 'А' + 1);
            else
                sb.append(spacedText.charAt(i));
        }
        return sb.toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
