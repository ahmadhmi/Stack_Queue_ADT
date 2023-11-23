package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyStack<Integer> test = new MyStack<>();
        test.push(0);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        MyStack<Integer> test2 = new MyStack<>();
        test2.push(0);
        test2.push(1);
        test2.push(2);
        test2.push(3);
        test2.push(4);
        System.out.println(test.equals(test2));
        System.out.println(test.pop());
        System.out.println(test.size());
        System.out.println(Arrays.toString(test.toArray()));
        System.out.println(test.peek());
        System.out.println(Arrays.toString(test.toArray()));
        System.out.println(test.search(3));



    }


}