import lab2.*;
import utils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        lab2();
    }

    static void lab2() {
        Task1 task1 = new Task1(new String[]{"you", "cool", "why", "hi", "are", "why"});
        System.out.println(Arrays.toString(task1.orderByLength(ArrayUtils.OrderType.ASC)));
        System.out.println(Arrays.toString(task1.getLengths()));
        Task2 task2 = new Task2(new double[]{1, 2, 0, 0.6, 0.8, -0.9, 0, 15, 16});
        System.out.printf("%.2f", task2.prodEven());
        System.out.println();
        System.out.printf("%.2f", task2.sumBetweenFirstAndLastNulls());
        System.out.println();
        System.out.println(Arrays.toString(task2.orderPositiveThanNegative()));
        Task3 task3 = new Task3("Работать на новой работе - великолепнор ");
        System.out.println(task3.stuff());
        Task4 task4 = new Task4("hellooo wworlld");
        System.out.println(Arrays.toString(task4.orderCharsByFrequency()));
        Task5 task5 = new Task5("hello");
        System.out.println(task5.reverse());
        Task6 task6 = new Task6('*', 3, 2);
        task6.drawRectangle();
        System.out.println(Task7.gcd(7, 60));
    }
}
