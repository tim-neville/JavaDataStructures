package com.timneville.Queues;

/**
 * Created by timneville on 5/7/17.
 */
public interface DequeADT<E> {
    /** Returns the number of elements in the deque */
    int size();
    /** Returns a boolean indicating whether the deque is empty */
    boolean isEmpty();
    /** Returns the first element of the deque, without removing it (or null if empty) */
    E first();
    /** Returns the last element of the deque, without removing it (or null if empty) */
    E last();
    /** Insert a new element e at the FRONT of the deque*/
    void addFirst(E element);
    /** Insert a new element e at the BACK of the deque*/
    void addLast(E element);
    /** Remove and return the first element of the deque (or null if empty) */
    E removeFirst();
    /** Remove and return the last element of the deque (or null if empty) */
    E removeLast();
}
