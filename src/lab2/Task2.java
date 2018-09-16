package lab2;

import utils.ArrayUtils;

import static utils.ArrayUtils.OrderType;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Task2 {

    private double array[];

    public Task2(double[] array) {
        this.array = array;
    }

    public Task2() {
        this(new double[0]);
    }

    public double sumPositive() {
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        double sum = 0;
        for (double d : array) {
            if (d > 0)
                sum += d;
        }
        return sum;
    }

    public double[] descOrder() {
        return unbox(ArrayUtils.sort(box(array), OrderType.DESC));
    }

    public double prodBetweenAsbMinAndAbsMax() {
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        int min = Math.min(absMinIndex(), absMaxIndex());
        int max = Math.max(absMinIndex(), absMaxIndex());
        double prod = 1;
        for (int i = min + 1; i < max; i++)
            prod *= array[i];
        return prod;
    }

    int absMinIndex() {
        if (array.length == 0)
            return -1;
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(array[index]))
                index = i;
        }
        return index;
    }

    int absMaxIndex() {
        if (array.length == 0)
            return -1;
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) > Math.abs(array[index]))
                index = i;
        }
        return index;
    }

    private Double[] box(double[] array) {
        return DoubleStream.of(array).boxed().toArray(Double[]::new);
    }

    private double[] unbox(Double[] array) {
        return Stream.of(array).mapToDouble(Double::doubleValue).toArray();
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }
}
