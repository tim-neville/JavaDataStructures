package com.timneville;

/**
 * Created by timneville on 29/6/17.
 */
    public interface Stack_Interface<E> {
        //@return the number of elements in the stack
        int size();
        //@return true if the stack is empty
        boolean isEmpty();
        //@param element to be inserted at top of the stack
        void push(E element);
        //@returns top element in the stack(or null if empty), does not remove
        E top();
        //@returns element removed from top of stack
        E pop();
    }
