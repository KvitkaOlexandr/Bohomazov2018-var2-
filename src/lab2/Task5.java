package lab2;

import utils.ArrayUtils;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static utils.ArrayUtils.OrderType;

public class Task5 {

    private int[] array;

    public Task5(int[] array) {
        this.array = array;
    }

    public Task5() {
        this(new int[0]);
    }

    public int[] ascOrder() {
        return unbox(ArrayUtils.sort(box(array), OrderType.ASC));
    }

    private Integer[] box(int[] array) {
        return IntStream.of(array).boxed().toArray(Integer[]::new);
    }

    private int[] unbox(Integer[] array) {
        return Stream.of(array).mapToInt(Integer::intValue).toArray();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
