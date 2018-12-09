package lab2.task2strategy;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Task2 {


    protected double array[];

    public Task2(double[] array) {
        this.array = array;
    }

    public Task2() {
        this(new double[0]);
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

    protected Double[] box(double[] array) {
        return DoubleStream.of(array).boxed().toArray(Double[]::new);
    }

    protected double[] unbox(Double[] array) {
        return Stream.of(array).mapToDouble(Double::doubleValue).toArray();
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

}
