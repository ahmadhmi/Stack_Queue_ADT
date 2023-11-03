package org.example;


/**
*
* StackADT.java
*
* @author Ahmad Heshmati, Syed Jawad Raza Baquar
* @version 1.0
*
*
* Class Definition: DateADT interface represents the public contract for the implementation of a Stack Class.
*                   Stack can be implemented to store any datatype, but all the element must be all of a same datatype .
*                   Stack must be able to add the given data to the end of the stack, remove the last element of the stack, remove and then return the value of the last element of the stack,
*                   search for a given value and return the location of the element in the stack, return the boolean value to reveal if the stack is empty, return a boolean value to reveal if the stack is full.
*
*
*
* */


public interface StackADT <T> {

    /**
     * Mutator method to add a given value to the end of the stack
     * <p>
     * Precondition: A valid value exists to be added
     * <p>
     * Postcondition: The given value is added to the end of the stack.
     *
     * @param data the given value to add to the end of the stack
     */
    void push(T data);
    /**
     * Accessor method to return the last element of the stack
     * */
    void peek();
    T pop();
    int search(T data);
    boolean empty();
    boolean isFull();

}