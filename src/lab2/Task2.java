package lab2;

import utils.ArrayUtils;

import static utils.ArrayUtils.OrderType;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.Arrays;

public class Task2 implements Visitor {

    public void sumPositive(double[] a) {
        Task2Code code = new Task2Code(a);
        System.out.printf("%.2f\n", code.sumPositive());
    }

    public void prodElements(double[] a) {
        Task2Code code = new Task2Code(a);
        System.out.printf("%.2f\n", code.prodBetweenAsbMinAndAbsMax());
    }

    public void orderElements(double[] a) {
        Task2Code code = new Task2Code(a);
        System.out.println(Arrays.toString(code.descOrder()));
    }

}
