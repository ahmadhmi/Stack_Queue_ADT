package org.example;

public interface QueueADT <T> {
    /**
     * Adds the provided object to the queue
     * @param data any generic object
     */
    void enqueue(T data);

    /**
     * Returns the first element in a queue
     * @return T any generic object
     */
    T dequeue();

    /**
     * Traverses the queue looking for the specified
     * @return
     */
    int search();

    /**
     * Returns true if the queue is full and is incapable of
     * accepting new elements, false otherwise
     * @return boolean
     */
    boolean isFull();

    /**
     * Retuens true if the queue is empty, false otherwise
     * @return boolean
     */
    boolean empty();

}
