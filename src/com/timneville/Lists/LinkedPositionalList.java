package com.timneville.Lists;

/**
 * Created by timneville on 15/8/17.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<> (null, header, null);
        header.setNext(trailer);
    }

    //utility methods
    private Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node)) throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) position; //safe cast
        if (node.getNext() == null)
            throw new IllegalArgumentException("position is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    private Position<E> addBetween(E element, Node<E> pred, Node<E> succ) {
        Node<E> newNode = new Node<>(element, pred, succ); //create and link a new node
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
        return newNode;
    }

    //accessor methods
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    //uses utility method to get position
    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return position(node.getNext());
    }

    //public update methods
    public Position<E> addFirst(E element) {
        return addBetween(element, header, header.getNext()); //just after the header
    }

    public Position<E> addLast(E element) {
        return addBetween(element, trailer.getPrev(), trailer); //just after the trailer
    }

    public Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return addBetween(element, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return addBetween(element, node, node.getNext());
    }

    public E set(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        E oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }

    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E removedElement = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return removedElement;
    }

    //nested Node class//
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;


        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
        public Node(E element, Node<E> prev,Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        public void setElement(E element) { this.element = element; }

        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    //end nested Node class//
}
