package com.timneville;

/**
 * Created by timneville on 29/6/17.
 */

/**
 *  LinkedList Stack does not suffer from a limited capacity and memory usage always proportional to number of elements in the stack.
 *
 *  As this is a singly linked list, the top should be the head, so we can insert and delete elements in O(1) constant time.
 */

public class Stack_LinkedStack<E> implements Stack_Interface<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public Stack_LinkedStack() {}

    @Override
    public int size() { return list.size(); }

    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public void push(E element) { list.addFirst(element); }

    @Override
    public E top() { return list.getFirst(); }

    @Override
    public E pop() { return list.removeFirst(); }
}
