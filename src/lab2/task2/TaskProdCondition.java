package lab2.task2;

public class TaskProdCondition extends Task2 implements Task2Interface<Double> {
    public TaskProdCondition(double[] array) {
        super(array);
    }

    public TaskProdCondition() {
        this(new double[0]);
    }

    @Override
    public Double resolve(Task2Visitor task2Visitor) {
        return task2Visitor.visit(this);
    }
}