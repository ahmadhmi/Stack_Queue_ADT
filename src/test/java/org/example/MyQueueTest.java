package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class MyQueueTest {
    MyQueue<Integer> q1 ;
    MyQueue<Integer> q2 ;
    @Before
    public void setUp() throws Exception {
        q1 = new MyQueue<>();
        q2 = new MyQueue<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() throws EmptyQueueException {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);

        int actualSize = q1.size();
        assertEquals(4, actualSize);

        assertEquals(Integer.valueOf(1), q1.dequeue());
        assertEquals(Integer.valueOf(2), q1.dequeue());
        assertEquals(Integer.valueOf(3), q1.dequeue());
        assertEquals(Integer.valueOf(4), q1.dequeue());

    }

    @Test
    public void dequeue() {
    }

    @Test
    public void peek() {
    }

    @Test
    public void dequeueAll() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void iterator() {
    }

    @Test
    public void testEquals() {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        assertTrue(q1.equals(q2));
    }

    @Test
    public void toArray() {
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void isFull() {
    }

    @Test
    public void size() {
    }
}