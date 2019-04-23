package lab2_v2.Task6.console;

import lab2_v2.Task6.NumbersModel;

import java.util.Arrays;
import java.util.concurrent.Flow;

public class ConsoleView implements Flow.Subscriber<NumbersModel> {

    private Flow.Subscription subscription;

    public void printNumbers(NumbersModel model) {
        System.out.println("Strings list: ");
        for (int num : model.getArray()) {
            System.out.println(num);
        }
    }

    public void printEvenSum(int sum) {
        System.out.println("Even sum: ");
        System.out.println(sum);
    }

    public void printAddedNum(int num) {
        System.out.println("Added num: " + num);
    }

    public void printDeletedNum(int num) {
        System.out.println("Deleted num: " + num);
    }

    public void printErrorMessage() {
        System.out.println("Wrong command combination");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NumbersModel item) {
        System.out.println("Nums changed! New num array: " + Arrays.toString(item.getArray()));
        this.printEvenSum(item.evenSum());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
