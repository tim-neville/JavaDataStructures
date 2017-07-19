package com.timneville.Queues;

/**
 * Created by timneville on 29/6/17.
 */

/**
 *
 *  Index 0 as the initial front of the queue. Enqueue added at index [+1].
 *  To remove with O(1) runtime & not have to shift all elements when we dequeue, we can simply replace a dequeued element
 *  with 'null'. So the front is kept track of and becomes the next index in the array.
 *
 *  For a fixed array length, when the end of the array is reached, enqueue wraps around and starts again at Index 0, but will be end of the queue.
 *
 * **/
public class ArrayQueue<E> implements QueueADT<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;   //note is not size of the array itself. Serves a numberOfElements/sizeOfQueue and lastElement n-1.

    public ArrayQueue() {
        this(CAPACITY);
    }
    public ArrayQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int nextSlot = (front + size) % data.length;
        data[nextSlot] = element;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) { return null; }
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) { return null; }

        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }
}
