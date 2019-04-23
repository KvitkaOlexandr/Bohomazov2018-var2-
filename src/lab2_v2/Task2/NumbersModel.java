package lab2_v2.Task2;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbersModel {

    private int[] array;
    private int currentPosition;
    private SubmissionPublisher<NumbersModel> publisher;

    public NumbersModel(int[] array) {
        this.array = array;
        this.currentPosition = 0;
        this.publisher = new SubmissionPublisher<>();
    }

    public NumbersModel() {
        this(new int[10]);
    }

    public void addNumber(int number) {
        array[currentPosition] = number;
        currentPosition++;
        if (currentPosition == array.length) {
            int[] newInts = new int[array.length + 10];
            System.arraycopy(array, 0, newInts, 0, array.length);
            array = newInts;
        }
        publisher.submit(this);
    }

    public void deleteNumber(int position) {
        if (currentPosition - position >= 0)
            System.arraycopy(array, position + 1, array, position, currentPosition - position);
        currentPosition--;
        publisher.submit(this);
    }

    public int evenSum() {
        int sum = 0;
        for (int d : array) {
            if (d % 2 != 0)
                sum += d;
        }
        return sum;
    }

    public int[] getArray() {
        return array;
    }

    public Integer[] getBoxedArray(){
        return box(array);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public SubmissionPublisher<NumbersModel> getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumbersModel that = (NumbersModel) o;

        return Arrays.equals(array, that.array);
    }

    private Integer[] box(int[] array) {
        return IntStream.of(array).boxed().toArray(Integer[]::new);
    }

    private int[] unbox(Integer[] array) {
        return Stream.of(array).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "NumbersModel{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
