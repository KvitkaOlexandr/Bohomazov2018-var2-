package lab2.task2;

public class TaskSumPositive extends Task2 implements Task2Interface<Double> {
    public TaskSumPositive(double[] array) {
        super(array);
    }

    public TaskSumPositive() {
        this(new double[0]);
    }

    @Override
    public Double resolve(Task2Visitor task2Visitor) {
        return task2Visitor.visit(this);
    }
}