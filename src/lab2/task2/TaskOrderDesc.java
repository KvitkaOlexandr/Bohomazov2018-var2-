package lab2.task2;

public class TaskOrderDesc extends Task2 implements Task2Interface<double[]> {

    public TaskOrderDesc(double[] array) {
        super(array);
    }

    public TaskOrderDesc() {
        this(new double[0]);
    }

    @Override
    public double[] resolve(Task2Visitor task2Visitor) {
        return task2Visitor.visit(this);
    }
}