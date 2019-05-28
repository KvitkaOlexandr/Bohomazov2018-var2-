package lab2_v2.Task1.console;

import lab2_v2.Task1.Observer;
import lab2_v2.Task1.StringsModel;

import java.util.Arrays;

public class ConsoleView implements Observer {

    public void printStrings(StringsModel model) {
        System.out.println("Strings list: ");
        for (String s : model.getStrings()) {
            System.out.println(s);
        }
    }

    public void printLongestString(String s) {
        System.out.println("Longest string: ");
        System.out.println(s);
    }

    public void printAddedString(String s) {
        System.out.println("Added string: " + s);
    }

    public void printDeletedString(String s) {
        System.out.println("Deleted string: " + s);
    }

    public void printErrorMessage() {
        System.out.println("Wrong command combination");
    }

    @Override
    public void update(StringsModel model) {
        System.out.println("Strings changed! New strings array: " + Arrays.toString(model.getStrings()));
        System.out.println("Longest string: " + model.longestString());
    }

}
