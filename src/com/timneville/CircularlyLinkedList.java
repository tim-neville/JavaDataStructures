package com.timneville;

import java.util.List;

/**
 * Created by timneville on 12/6/17.
 */
public class CircularlyLinkedList<E> /*implements List*/ {

    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList() {}
    //access methods
    public int size() {return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }
    //update methods
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }
    public void addFirst(E element) {
        if (size == 0) {
            tail = new Node<>(element, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E element) {
        addFirst(element);
        tail = tail.getNext();
    }
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    //nested Node class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        private Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        private E getElement() { return element; }
        private Node<E> getNext() { return next; }
        private void setNext(Node<E> next) { this.next = next; }
    } //end nested Node class
}
