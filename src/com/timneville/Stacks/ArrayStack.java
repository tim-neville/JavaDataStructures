package com.timneville.Stacks;

/**
 * Created by timneville on 29/6/17.
 */

/**
 * Limitation with ArrayStack is the limited capacity of the array.
 * Operations though, are O(1)
 *
 * Note- two constructor signatures, one for default capacity, another to set user defined.
 *
 * Note-push() method, the ++top increments top then returns the result for adding the new top element.
 *
 * Note-pop() setting data[top] to null not technically required, but assists Garbage Collection by removing reference
 */

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;
    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int capacity) {   //... or construct with given capacity
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
        if (size() == data.length) throw new IllegalStateException("Lists is full");
        data[++top] = element;
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
        data[top] = null;
        top--;
        return answer;
    }

}

