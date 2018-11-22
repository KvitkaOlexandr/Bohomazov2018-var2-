package lab2.task2;

import lab2.task2.Task2Visitor;

public interface Task2Interface<T> {
    public T resolve(Task2Visitor task2Visitor);
}
