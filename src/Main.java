import lab2.*;
import utils.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        lab2();
    }

    static void lab2() {
        Task1 task1 = new Task1(new String[]{"you", "cool", "why", "hi", "are", "why"});
        System.out.printf("Longest string: %s, it\'s length: %d \n", task1.longestString(), task1.longestString().length());
        Task2 task2 = new Task2(new double[]{1, 2, 0, 0.6, 0.8, -0.9, 0, 15, 16});
        System.out.printf("%.2f\n", task2.sumPositive());
        System.out.printf("%.2f\n", task2.prodBetweenAsbMinAndAbsMax());
        System.out.println(Arrays.toString(task2.descOrder()));

        //TODO edit this tasks
        Task3 task3 = new Task3("Работать на новой работе - великолепнор ");
        System.out.println(task3.stuff());
        //TODO
        Task4 task4 = new Task4("hellooo wworlld");
        System.out.println(Arrays.toString(task4.orderCharsByFrequency()));

        Task5 task5 = new Task5(new int[]{1, 6, 5, 7, 3, 7, 9, 3});
        System.out.println(Arrays.toString(task5.ascOrder()));
        //TODO
        Task6 task6 = new Task6('*', 3, 2);
        task6.drawRectangle();
        //TODO
        System.out.println(Task7.gcd(7, 60));
    }
}
