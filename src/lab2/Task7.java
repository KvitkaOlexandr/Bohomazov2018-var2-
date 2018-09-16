package lab2;

public class Task7 {

    private int a, b, c;

    public Task7(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int isTriangle() {
        if (maxSide() >= middleSide() + minSide())
            return 0;
        if (minSide() == middleSide()) {
            if (maxSide() == minSide())
                return 3;
            else
                return 2;
        }
        return 1;
    }

    private int maxSide() {
        return max(a, b, c);
    }

    private int minSide() {
        return Math.min(Math.min(a, b), Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), Math.max(b, c));
    }

    private int middleSide() {
        return max(Math.min(a, b), Math.min(b, c), Math.min(a, c));
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
