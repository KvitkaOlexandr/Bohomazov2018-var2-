package lab2.task2strategy;

public class ProdConditionStrategy extends Task2 implements Strategy<Double> {

    @Override
    public Double execute() {
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        int min = Math.min(absMinIndex(), absMaxIndex());
        int max = Math.max(absMinIndex(), absMaxIndex());
        double prod = 1;
        for (int i = min + 1; i < max; i++)
            prod *= array[i];
        return prod;
    }
}
