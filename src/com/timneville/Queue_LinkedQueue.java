package com.timneville;

import java.util.Queue;

/**
 * Created by timneville on 29/6/17.
 */


/**
 *  Each method runs in O(1) time
 *
 *  Linked-list method of queues more expensive in time and size than a properly sized ArrayQueue
 *  due to Node instantiation and initialization of a new node, as well as references stored for next node.
 *
 * */
public class Queue_LinkedQueue<E> implements Queue_Interface<E> {
    /** Adaptor pattern **/
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public Queue_LinkedQueue() {}

    @Override
    public int size() { return list.size(); }

    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E first() {
        return list.getFirst();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
