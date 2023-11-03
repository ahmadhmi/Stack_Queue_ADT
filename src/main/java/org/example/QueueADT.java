package org.example;

public interface QueueADT <T> {
    void enqueue(T data);
    T dequeue();
    int search();
    boolean isFull();
    boolean empty();

}
