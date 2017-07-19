package com.timneville.Lists;

/**
 * Created by timneville on 19/7/17.
 */

/** A simplified version of the java.util.List interface. */
/** Abstract because it doesn't specify HOW the ADT is implemented. ADT can have multiple different implementations */
public interface ListADT<E> {

    //note how all methods, when specified in an, interface dont require access modifiers as they must all be public
    int size();

    boolean isEmpty();

    /** Returns (but does not remove) the element at index */
    E get(int atIndex) throws IndexOutOfBoundsException;

    /** Replaces the element at index with passed in element, and returns the old/replaced element */
    E set(int atIndex, E element) throws IndexOutOfBoundsException;

    /** Inserts element at index, shifting all subsequent elements later in list */
    void add(int atIndex, E element) throws IndexOutOfBoundsException;

    /** Removes/returns the element at index, shifting subsequent elements earlier in list*/
    E remove(int atIndex) throws IndexOutOfBoundsException;
}
