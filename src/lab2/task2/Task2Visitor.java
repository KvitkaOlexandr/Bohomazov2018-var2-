package lab2.task2;

public interface Task2Visitor {

    public double visit(TaskSumPositive taskSumPositive);

    public double visit(TaskProdCondition taskProdCondition);

    public double[] visit(TaskOrderDesc taskOrderDesc);

}