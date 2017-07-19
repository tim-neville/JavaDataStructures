package com.timneville.Lists;

/**
 * Created by timneville on 19/7/17.
 */

/** Dynamic ArrayList with ability to resize capacity via resize(int capacity) method */
public class ArrayListImpListADT<E> implements ListADT<E> {
    //instance variables
    private static final int CAPACITY = 16;  //initial capacity
    private E[] data;                       //data stored in an array
    private int size = 0;                   //size counter

    //constructors
    public ArrayListImpListADT() {
        this(CAPACITY);
    }
    public ArrayListImpListADT(int capacity) {
        data = (E[]) new Object[capacity]; //safe cast Object Array(super) as an E Array(sub).
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int atIndex) throws IndexOutOfBoundsException {
        checkIndexInRange(atIndex, size);
        return data[atIndex];
    }

    @Override
    public E set(int atIndex, E element) throws IndexOutOfBoundsException {
        checkIndexInRange(atIndex, size);
        E replacedElement = data[atIndex];
        data[atIndex] = element;
        return replacedElement;
    }

    @Override /** O(n) worst-case runtime due to having to shift elements */
    public void add(int atIndex, E element) throws IndexOutOfBoundsException {
        checkIndexInRange(atIndex, size+1);
        if (size == data.length)                                //check capacity, if at capacity then call resize() to increase referenced array capacity
            resize(2 * data.length);
        for (int k = size-1; k >= atIndex; k++)                 //shift elements, starting from list end, toward index
            data[k+1] = data[k];                                //shift left element one to the right.
        data[atIndex] = element;                                //insert new element
        size++;
    }

    @Override /** O(n) worst-case runtime due to having to shift elements */
    public E remove(int atIndex) throws IndexOutOfBoundsException {
        checkIndexInRange(atIndex, size);
        E removedElement = data[atIndex];
        for (int k = atIndex; k < size-1; k++)                  //shift elements, starting at removed index, toward end of list
            data[k] = data[k+1];                                //shift right element one to the left.
        data[size-1] = null;                                    //set last element of list to null; helps garbage collection
        size--;
        return removedElement;
    }

    //utility methods
    /** Checks whether the given index is in range [0, n-1] */
    protected void checkIndexInRange(int index, int arraySize) throws IndexOutOfBoundsException {
        if (index < 0 || index >= arraySize)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    }

    /** Creates new larger array, copies the data from existing array, then replaces data reference to that of the new larger array */
    protected void resize(int capacity) {
        E[] newResizedArray = (E[]) new Object[capacity];       //safe case Object Array as an E array
        for (int k = 0; k < size; k++)                          //loop through and copy data from original array to new resized array
            newResizedArray[k] = data[k];
        data = newResizedArray;                                 //replace original array reference with new array reference.
    }
}
