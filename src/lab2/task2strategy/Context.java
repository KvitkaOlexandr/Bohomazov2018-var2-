package lab2.task2strategy;

public class Context<T> {

    private Strategy<T> strategy;

    public Context(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    public T executeStrategy() {
        return strategy.execute();
    }
}
