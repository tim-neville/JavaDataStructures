package com.timneville.Queues;

/**
 * Created by timneville on 5/7/17.
 */
public class DoubleEndedArray<E> implements DequeInterface<E> {
    private static final int CAPACITY = 1000;
    private int size = 0;
    private int front = 0;
    private E[] data;

    public DoubleEndedArray() { this(CAPACITY); }
    public DoubleEndedArray(int capacity) {
        this.data = (E[]) new Object[capacity];
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
    public E first() {
        if (isEmpty()) { return null; }
        return data[front];
    }

    public int lastIndex() {
        return ((front-1 + size) % data.length);
    }

    @Override
    public E last() {
        if (isEmpty()) { return null; }
        return data[lastIndex()];
    }

    @Override
    public void addFirst(E element) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int nextSlot = (front + size) % data.length;    //wraps around using modulo
        data[nextSlot] = element;
        size++;
    }

    @Override
    public void addLast(E element) {
        if (size == data.length) throw new IllegalStateException(("Queue is full"));
        int nextSlot = (lastIndex() + 1);
        data[nextSlot] = element;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) { return null; }
        E answer = first();
        data[front] = null;
        front = (front + 1) % data.length;              //wraps around using modulo
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) { return null; }
        E answer = last();
        data[lastIndex()] = null;
        size--;
        return answer;
    }
}
