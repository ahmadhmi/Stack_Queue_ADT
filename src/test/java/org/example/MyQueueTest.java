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
    public void dequeue() throws EmptyQueueException {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);

        assertEquals(Integer.valueOf(1), q1.dequeue());

        int actualSize = q1.size();
        assertEquals(3, actualSize);

        assertEquals(Integer.valueOf(2), q1.dequeue());

        int actualSize2 = q1.size();
        assertEquals(2, actualSize2);
    }

    @Test
    public void peek() throws EmptyQueueException {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);

        assertEquals(Integer.valueOf(1), q1.peek());

        int actualSize = q1.size();
        assertEquals(4, actualSize);

        q1.dequeue();

        assertEquals(Integer.valueOf(2), q1.peek());
    }

    @Test
    public void dequeueAll() {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);

        q1.dequeueAll();

        int actualSize = q1.size();
        assertEquals(0, actualSize);

    }

    @Test
    public void isEmpty() {
        assertTrue(q1.isEmpty());

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);

        assertFalse(q1.isEmpty());
    }

    @Test
    public void iterator() {
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);

        Iterator<Integer> it = q1.iterator();

        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("First element should be 1", Integer.valueOf(1), it.next());
        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("Second element should be 2", Integer.valueOf(2), it.next());
        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("Third element should be 3", Integer.valueOf(3), it.next());
        assertFalse("Iterator should not have any more elements", it.hasNext());
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
        Integer[] testArray = new Integer[1];
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        Integer[] actual = q1.toArray(testArray);
        Integer[] expected = {10, 20, 30, 40};
        assertEquals(expected, actual);
    }

    @Test
    public void testToArray() {
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        Object[] actual = q1.toArray();
        Object[] expected = {10, 20, 30};
        assertEquals(expected, actual);
    }

    @Test
    public void isFull() {
        assertFalse(q1.isFull());
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        assertFalse(q1.isFull());
    }

    @Test
    public void size() {
        int actualSize = q1.size();
        assertEquals(0, actualSize);

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);

        int actualSize2 = q1.size();
        assertEquals(4, actualSize2);
    }
}