package com.timneville;

/**
 * Created by timneville on 21/6/17.
 */
public class DoublyLinkedList<E> {
    /** instance variables */
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    /** constructor */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,null,null);
        header.setNext(trailer);
    }

    /** accessor methods */
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) { return null; }
        //since header of DLL is null, 'first' is the next node after the header.
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) { return null; }
        //since trailer of DLL is null, 'last' is the prev node from the trailer.
        return trailer.getPrev().getElement();
    }

    /** public update methods */
    //Adds element between header and next node
    public void addFirst(E element) {
        addBetween(element, header, header.getNext());
    }

    //Add element between trailer and the prev node
    public void addLast(E element) {
        addBetween(element, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) { return null; }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) { return null; }
        return remove(trailer.getPrev());
    }

    /** private update methods */
    private void addBetween(E element, Node<E> previousNode, Node<E> nextNode) {
        //create and link a new node
        Node<E> newest = new Node<>(element, previousNode, nextNode);
        previousNode.setNext(newest);
        nextNode.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> previousNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        //unlink the node by pointing prev to next, and next to prev Nodes
        previousNode.setNext(nextNode);
        nextNode.setPrev(previousNode);
        size--;
        return node.getElement();
    }









    //nested Node class
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        private Node(E element, Node<E> prev,Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        private E getElement() { return element; }
        private Node<E> getPrev() { return prev; }
        private Node<E> getNext() { return next; }
        private void setPrev(Node<E> prev) { this.prev = prev; }
        private void setNext(Node<E> next) { this.next = next; }
    } //end nested Node class
}
