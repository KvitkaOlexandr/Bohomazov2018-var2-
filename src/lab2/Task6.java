package lab2;

public class Task6 {

    private int[] array;

    public Task6(int[] array) {
        this.array = array;
    }

    public Task6() {
        this(new int[0]);
    }

    public int evenSum() {
        int sum = 0;
        for (int d : array) {
            if (d % 2 != 0)
                sum += d;
        }
        return sum;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
