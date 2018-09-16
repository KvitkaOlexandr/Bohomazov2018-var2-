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

    public double prodEven() {
        double prod = 1;
        for (int i = 1; i < array.length; i += 2) {
            prod *= array[i];
        }
        return prod;
    }

    public double sumBetweenFirstAndLastNulls() {
        int firstIndex = ArrayUtils.indexOf(array, 0, OrderType.ASC);
        int lastIndex = ArrayUtils.indexOf(array, 0, OrderType.DESC);
        if (firstIndex == -1)
            firstIndex = 0;
        if (lastIndex == -1)
            lastIndex = array.length - 1;
        double sum = 0;
        for (int i = firstIndex + 1; i < lastIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    public double[] orderPositiveThanNegative() {
        double[] result = new double[array.length];
        int j = 0;
        for (double d : array) {
            if (d >= 0) {
                result[j] = d;
                j++;
            }
        }
        for (double d : array) {
            if (d < 0) {
                result[j] = d;
                j++;
            }
        }
        return result;
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
