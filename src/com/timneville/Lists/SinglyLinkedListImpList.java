package com.timneville.Lists;

import java.util.*;
import com.timneville.Node;

/**
 * Created by timneville on 21/6/17.
 */
public class SinglyLinkedListImpList<E> implements List<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedListImpList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns true if this list contains the specified element
    @Override
    public boolean contains(Object o) {
        while (iterator().hasNext()) {
            E element = iterator().next();
            if (iterator().next().equals(o)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //Returns an iterator over the elements in this list in proper sequence.
    @Override
    public Iterator<E> iterator() {
        if (isEmpty()) {
            return Collections.<E>emptyList().iterator();
        }

        return new Iterator<E>() {
            Node<E> currentNode;
            @Override //hasNext() - Returns true if there is at least one additional element in the sequence.
            public boolean hasNext() {
                if (currentNode == null) {
                    currentNode = head;
                }
                return currentNode.getNext() != null;
            }

            @Override //next() Returns the next element in the sequence. throws NoSuchElementException
            public E next() {
                if(!hasNext()) { return null; }
                E answer = currentNode.getElement();
                currentNode = currentNode.getNext();
                return answer;
            }
        };
    }

    //Appends the specified element to the end of this list
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        return true;
    }

    //Inserts the specified element at the specified position in this list
    @Override
    public void add(int index, E element) {
        int indexCounter = 0;
        Node<E> currentNode = head;
        Node<E> newNode = new Node<>(element, null);
        Node<E> newNodeNext = null;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            if (index > size-1) throw new IndexOutOfBoundsException();
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();             //traverse the list to one before the index location
                indexCounter++;
            }
            if (currentNode.getNext() != null) {
                newNodeNext = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setNext(newNodeNext);
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //Returns the element at the specified position in this list.
    @Override
    public E get(int index) {
        if (isEmpty()) return null;
        if (index == 0) return head.getElement();
        if (index == size-1) return tail.getElement();

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}
