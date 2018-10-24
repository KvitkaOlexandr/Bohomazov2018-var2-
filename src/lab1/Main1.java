import lab1.task1.*;
import lab1.task2.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main1 {
	public static void main(String[] args) {
        lab1_1();
     }

	static void lab1_1(){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Input new password:");

            String password = bis.readLine();
            PasswordValidator pc = new PasswordValidator(password);
            
            System.out.println("Input password:");

            String newPassword = bis.readLine();
            if(pc.validate(newPassword))
                System.out.println("Correct password");
            else
                System.out.println("Wrong password");

        } catch (IOException e) {
            System.out.print("Input Error " + e);
        }
	}
}