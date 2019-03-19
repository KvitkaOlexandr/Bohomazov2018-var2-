package task2;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Calculator {

    private double array[];

    public Calculator() {
        this(new double[0]);
    }

    public Calculator(double[] newArray) {
        array = newArray;
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
        return unbox(ArrayUtils.sort(box(array), ArrayUtils.OrderType.DESC));
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

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}
	
	@Override
    public String toString() {
    	String ret = "";
    	for(double d : array) {
    		ret = ret + " " + String.valueOf(d);
    	}
        return ret;
    }
}