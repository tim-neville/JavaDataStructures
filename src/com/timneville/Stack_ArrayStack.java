package com.timneville;

/**
 * Created by timneville on 29/6/17.
 */

public class Stack_ArrayStack<E> implements Stack_Interface<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;
    public Stack_ArrayStack() {   //construct stack with default capacity...
    }
    public Stack_ArrayStack(int capacity) {   //... or construct with given capacity
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++top] = element;  //increments and returns new top index ready for insertion
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[top];
        data[top] = null;       //while not technically required, removing reference assists JavaGarbageCollection
        top--;
        return answer;
    }

}

