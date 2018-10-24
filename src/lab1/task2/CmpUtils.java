package lab1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CmpUtils {
	
	public static int getOneInteger(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
	
	public static int[] getNIntegers(int num) {

        if (num < 1) {
            throw new IllegalArgumentException("number of integers can't be less than 1");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arrStr[] = new String[num];

        int arrInt[] = new int[num];

        try {

            for (int i = 0; i < num; i++) {
                arrStr[i] = br.readLine();
                arrInt[i] = Integer.parseInt(arrStr[i]);
            }

        } catch (IOException e) {
            System.out.println("error " + e);
        } catch (NumberFormatException e) {
            System.out.println("can't parse integer " + e);
        }

        return arrInt;
    }
}
