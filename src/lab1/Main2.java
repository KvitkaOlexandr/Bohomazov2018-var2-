import lab1.task2.*;

import java.io.InputStreamReader;


public class Main2 {
	public static void main(String[] args) {
        lab1_2();
     }

	static void lab1_2(){
        InputStreamReader is = new 		 	  
        InputStreamReader(System.in);

        //Task 2
        try {
            System.out.println("enter number of integers");
            int num = CmpUtils.getOneInteger();

            System.out.println("enter numbers");
            int [] numbers = CmpUtils.getNIntegers(num);
                        
            NumberStorage numberStorage = new NumberStorage(numbers);

            System.out.println("dividable by 9 \r\n" + numberStorage.findDividableIntegers(9));
            System.out.println("dividable by 3 \r\n" + numberStorage.findDividableIntegers(3));

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong input: " + e);
        }
    }
}