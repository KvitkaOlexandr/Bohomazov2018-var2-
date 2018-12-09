package lab2.task2strategy;

public class SumPositiveStrategy extends Task2 implements Strategy<Double> {

    @Override
    public Double execute() {
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        double sum = 0;
        for (double d : array) {
            if (d > 0)
                sum += d;
        }
        return sum;
    }
}
