package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    MyStack<Integer> test = new MyStack<>();

    @Before
    public void setUp() throws Exception {

        test.push(0);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void push() {
        test.push(5);
        assertEquals(test.size(),6);
    }

    @Test
    public void pop() {
        test.pop();
        assertEquals(test.size(),4);
    }

    @Test
    public void peek() {
        int temp = test.peek();
        assertEquals(temp,4);
    }

    @Test
    public void clear() {
        test.clear();
        assertEquals(test.size(),0);
    }

    @Test
    public void isEmpty() {
        assertEquals(test.isEmpty(),false);
    }

    @Test
    public void toArray() {
        Object[] temp=test.toArray();
        assertEquals(temp[0],0);
        assertEquals(temp[1],1);
        assertEquals(temp[2],2);
        assertEquals(temp[3],3);
        assertEquals(temp[4],4);
    }

    @Test
    public void testToArray() {
        Integer[] temp = new Integer[6];
        Integer[] holder=test.toArray(temp);
        assertEquals(holder.length,6);
    }

    @Test
    public void contains() {

        assertEquals(test.contains(2),true);
    }

    @Test
    public void search() {
        int temp=test.search(3);
        assertEquals(temp,2);
    }

    @Test
    public void iterator() {
        boolean result = true;
        Integer[] test2 = new Integer[4];
        Integer[] holder=test.toArray(test2);
        for(int i =0 ; i<test.size();i++){
            if (holder[i] != test.pop()) {
                result = false;
            }
        }
        assertEquals(result,true);
    }

    @Test
    public void testEquals() {
        MyStack<Integer> test2 = new MyStack<>();
        test2.push(0);
        test2.push(1);
        test2.push(2);
        test2.push(3);
        test2.push(4);

        assertEquals(test.equals(test2),true);
    }

    @Test
    public void size() {
        int temp=test.size();
        assertEquals(temp,5);
    }
}