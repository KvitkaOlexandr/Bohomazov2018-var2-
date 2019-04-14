package lab5_1;

import java.util.ArrayList;

public class NumberListOperator {

    public ArrayList<Integer> AddFirstOddNumber(ArrayList<Integer> list) {
        var resList = new ArrayList<Integer>();
        int firstOddAbsolute = getFirstOddAbsolute(list);
        for (int number :
                list) {
            resList.add(number + firstOddAbsolute);
        }
        return resList;
    }

    private int getFirstOddAbsolute(ArrayList<Integer> list) {
        int firstOddAbsolute = 0;
        for (int number :
                list) {
            if (number % 2 != 0) {
                firstOddAbsolute = Math.abs(number);
                break;
            }
        }
        return firstOddAbsolute;
    }
}
