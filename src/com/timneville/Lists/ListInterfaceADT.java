package com.timneville.Lists;

/**
 * Created by timneville on 19/7/17.
 */

/** A simplified version of the java.util.List interface. */
public interface ListInterfaceADT<E> {

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
