package lab2;

public class Task6 {

    private int width;
    private int height;
    private char ch;

    public Task6(char ch, int width, int height) {
        this.width = width;
        this.height = height;
        this.ch = ch;
    }

    public void drawRectangle() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(ch);
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
}
