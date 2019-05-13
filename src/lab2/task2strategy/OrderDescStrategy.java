package lab2.task2strategy;

import utils.ArrayUtils;

public class OrderDescStrategy extends Task2 implements Strategy<double[]> {

    @Override
    public double[] execute() {
        return unbox(ArrayUtils.sort(box(array), ArrayUtils.OrderType.DESC));
    }

}
