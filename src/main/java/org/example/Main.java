package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(2, 5);
        list.add(5, 6);
        System.out.println(Arrays.toString(list.toArray()));
    }


}