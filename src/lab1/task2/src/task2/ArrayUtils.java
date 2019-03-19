package task2;

public class ArrayUtils {

    public enum OrderType {ASC, DESC}

    public static <T extends Comparable<T>> T[] sort(T[] array, OrderType orderType) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (orderType == OrderType.ASC) {
                    if (array[i].compareTo(array[j]) > 0) {
                        ArrayUtils.swap(array, i, j);
                    }
                } else if (orderType == OrderType.DESC) {
                    if (array[i].compareTo(array[j]) < 0) {
                        ArrayUtils.swap(array, i, j);
                    }
                }
            }
        }
        return array;
    }

    public static int indexOf(double[] array, double seed, OrderType orderType) {
        if (orderType == OrderType.ASC) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == seed)
                    return i;
            }
        } else if (orderType == OrderType.DESC) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == seed)
                    return i;
            }
        }
        return -1;
    }

    public static <T> int indexOf(T[] array, T seed, OrderType orderType) {
        if (orderType == OrderType.ASC) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(seed))
                    return i;
            }
        } else if (orderType == OrderType.DESC) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i].equals(seed))
                    return i;
            }
        }
        return -1;
    }

    public static <T> void swap(T[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length)
            return;
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static double[] stringToDouble(String string){
        String strArr[] = string.split(" ");
        double numbers[] = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numbers[i] = Double.parseDouble(strArr[i]);
        }
        return numbers;
    }

    public static boolean validateString(String string){
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) < '0' || string.charAt(i) > '9'){
                if(string.charAt(i) != ' ' && string.charAt(i) != '.' && string.charAt(i) != '-')
                    return false;
            }
        }
        return true;
    }
}
