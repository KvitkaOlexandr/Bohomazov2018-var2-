package lab2.task2;

import utils.ArrayUtils;

public class Task2AlgorithmVisitor implements Task2Visitor {
    @Override
    public double visit(TaskSumPositive taskSumPositive) {
        double[] array = taskSumPositive.array;
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        double sum = 0;
        for (double d : array) {
            if (d > 0)
                sum += d;
        }
        return sum;
    }

    @Override
    public double visit(TaskProdCondition taskProdCondition) {
        double[] array = taskProdCondition.array;
        if (array.length == 0)
            throw new IndexOutOfBoundsException();
        int min = Math.min(taskProdCondition.absMinIndex(), taskProdCondition.absMaxIndex());
        int max = Math.max(taskProdCondition.absMinIndex(), taskProdCondition.absMaxIndex());
        double prod = 1;
        for (int i = min + 1; i < max; i++)
            prod *= array[i];
        return prod;
    }

    @Override
    public double[] visit(TaskOrderDesc taskOrderDesc) {
        return taskOrderDesc.unbox(ArrayUtils.sort(taskOrderDesc.box(taskOrderDesc.array), ArrayUtils.OrderType.DESC));
    }
}

