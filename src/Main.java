import lab1.task1.PasswordValidator;
import lab1.task2.NumberUtils;
import lab2.*;
import utils.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        lab1();
        //lab2();
    }

    static void lab2() {
        Task1 task1 = new Task1(new String[]{"you", "cool", "why", "hi", "are", "why"});
        System.out.printf("Longest string: %s, it\'s length: %d \n", task1.longestString(), task1.longestString().length());
        Task2 task2 = new Task2(new double[]{1, 2, 0, 0.6, 0.8, -0.9, 0.5, 15, 16});
        System.out.printf("%.2f\n", task2.sumPositive());
        System.out.printf("%.2f\n", task2.prodBetweenAsbMinAndAbsMax());
        System.out.println(Arrays.toString(task2.descOrder()));

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

    static void lab1(){
        //Task 1
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Input password:");

            String password = bis.readLine();
            PasswordValidator pc = new PasswordValidator();

            if(pc.validate(password))
                System.out.println("Correct password");
            else
                System.out.println("Wrong password");

        } catch (IOException e) {
            System.out.print("Input Error " + e);
        }

        //Task 2
        try {
            NumberUtils numberUtils = new NumberUtils();
            System.out.println("enter number of integers");
            int num = numberUtils.getOneInteger();

            System.out.println("enter numbers");
            int[] arrInt = numberUtils.getNIntegers(num);

            System.out.println("dividable by 9 \r\n" + numberUtils.findDividableIntegers(arrInt, 9));
            System.out.println("dividable by 3 \r\n" + numberUtils.findDividableIntegers(arrInt, 3));

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input: " + e);
        }
    }
}
