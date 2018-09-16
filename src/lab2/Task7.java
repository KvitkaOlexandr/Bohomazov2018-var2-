package lab2;

public class Task7 {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
