package com.timneville;

/**
 * Created by timneville on 29/6/17.
 */

/** Stack ADT */

public interface Stack_Interface<E> {
    /**@return the number of elements in the stack**/
    int size();
    /**@return true if the stack is empty**/
    boolean isEmpty();
    /**@param element to be inserted at top of the stack**/
    void push(E element);
    /**@return but does not remove, the top element in the stack(or null if empty)**/
    E top();
    /**@return element removed from top of stack**/
    E pop();
}
