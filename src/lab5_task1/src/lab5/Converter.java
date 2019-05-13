package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Converter {
    private int [] inputArray;
    private ArrayList convertedArray = new ArrayList();

    public Converter(){
        inputArray = new int[20];
        for(int i = 0; i < 20; i++){
            inputArray[i] = -50 + (int)Math.round(Math.random() * 100);
        }
        convert();
    }

    public Converter(int n){
        inputArray = new int[n];
        for(int i = 0; i < n; i++){
            inputArray[i] = -50 + (int)Math.round(Math.random() * 100);
        }
        convert();
    }

    public Converter(int [] array){
        inputArray = array;
        for(int i = 0; i < inputArray.length; i++){
            inputArray[i] = -50 + (int)Math.round(Math.random() * 100);
        }
        convert();
    }

    public ArrayList getConvertedArray() {
        return convertedArray;
    }

    public int[] getInputArray() {
        return inputArray;
    }

    private void convert(){
        double number = (inputArray[(inputArray.length - 1)] + findFirstNegative()) / 2;
        for(int i = 0; i < inputArray.length; i++){
            convertedArray.add(Math.round(inputArray[i] / number));
        }
    }

    private int findFirstNegative(){
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] < 0)
                return inputArray[i];
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Converter converter = (Converter) o;
        return Arrays.equals(inputArray, converter.inputArray) &&
                convertedArray.equals(converter.convertedArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(convertedArray);
        result = 31 * result + Arrays.hashCode(inputArray);
        return result;
    }

    @Override
    public String toString() {
        return  "inputArray=" + Arrays.toString(inputArray) + "\n" +
                "convertedArray=" + convertedArray;
    }
}

