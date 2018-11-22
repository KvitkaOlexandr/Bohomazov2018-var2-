import lab2.*;
import lab2.task2.*;
import utils.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        lab2();
    }

    private static void lab2() {
        task1();
        double[] tempArray = new double[]{1, 2, 0, 0.6, 0.8, -0.9, 0.5, 15, 16};
        System.out.println("Array for task2: " + Arrays.toString(tempArray));

        Task2AlgorithmVisitor visitor = new Task2AlgorithmVisitor();

        Task2Interface task = new TaskSumPositive(tempArray);
        System.out.printf("Positive sum: %.2f\n", task.resolve(visitor));
        task = new TaskProdCondition(tempArray);
        System.out.printf("Prod between min abs and max abs: %.2f\n", task.resolve(visitor));
        task = new TaskOrderDesc(tempArray);
        System.out.println("Order desc: " + Arrays.toString((double[]) task.resolve(visitor)));

        Task3 task3 = new Task3("Работать на новой работе - великолепнор ");
        System.out.println(task3.addTwoWhitespacesBetweenLetters());
        System.out.println(task3.replaceCharsWithCode());

        Task4 task4 = new Task4("Привет, как дела? Привет, как сам?");
        System.out.println(task4.wordFreqs());

        Task5 task5 = new Task5(new int[]{1, 6, 5, 7, 3, 7, 9, 3});
        System.out.println(Arrays.toString(task5.ascOrder()));
        Task6 task6 = new Task6(new int[]{1, 2, 3, 4, 7, 5, 6, 8});
        System.out.printf("Even sum: %d\n", task6.evenSum());
        Task7 task7 = new Task7(5, 5, 6);
        System.out.println(task7.isTriangle());
    }

    private static void task1() {
        //Task1 task1 = new Task1(new String[]{"you", "cool", "why", "hi", "are", "why"});
        Task1 t = new Task1(5);
        String[] strings = {"you", "cool", "why", "hi", "are", "why"};
        for (int i = 0; i < 6; i++) {
            t.addString(strings[i]);
        }
        t.deleteString(0);
        for (int i = 0; i < t.getStrings().length; i++) {
            System.out.println(t.getStrings()[i]);
        }
        System.out.printf("Longest string: %s, it\'s length: %d \n", t.longestString(), t.longestString().length());
    }

}
