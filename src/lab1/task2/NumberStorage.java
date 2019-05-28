package lab1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumberStorage {

    private int[] numbers;

    public NumberStorage(int[] num) {
        numbers = num;
    }


    public List<Integer> findDividableIntegers(int divider) {
        List<Integer> intList = new ArrayList<>();

        for (int el : numbers) {
            if (el % divider == 0) {
                intList.add(el);
            }
        }
        return intList;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i : numbers) {
            ret.append(" ").append(String.valueOf(i));
        }
        return ret.toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numbers == null) ? 0 : Arrays.hashCode(numbers));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumberStorage other = (NumberStorage) obj;
        if (numbers == null) {
            return other.numbers == null;
        } else {
            return Arrays.equals(numbers, other.numbers);
        }
    }

}	