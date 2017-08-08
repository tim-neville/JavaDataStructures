package com.timneville.Lists;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import com.timneville.Node;

/**
 * Created by timneville on 21/6/17.
 */
public class SinglyLinkedListImpList<E> implements List<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /** Constructors */
    public SinglyLinkedListImpList() {}

    public SinglyLinkedListImpList(E[] elements) throws IllegalStateException {
        //throw new IllegalStateException("String array was not passed in.");
        addAll(Arrays.asList(elements));
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
    public boolean contains(Object object) {
        if (isEmpty()) {
            return false;
        }
        return indexOf(object) != -1;
    }

    @Override
    public boolean add(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("null element passed");
        }

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

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (element == null) {
            throw new NullPointerException("null element passed");
        }
        Node<E> currentNode = head;
        Node<E> newNode = new Node<>(element, null);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            if (currentNode.getNext() != null) {
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            } else {
                currentNode.setNext(newNode);
                tail = newNode;
            }
        }
        size++;
    }

    @Override
    public boolean remove(Object object) {
        if (isEmpty()) { return false; }
        if (head.getElement() == object) {
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = head;
            }
            return true;
        }
        Node<E> currentNode = head;
        Node<E> prevNode = null;
        while (currentNode != null) {
            if (currentNode.getElement() == object) {
                prevNode.setNext(currentNode.getNext());
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();             //traverse the list
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException("null passed as collection");
        }

        //collection passed in is of type Collection interface, therefore adheres to collection interface methods.
        Iterator<?> specifiedCollection = collection.iterator();
        while (specifiedCollection.hasNext()) {
            Object element = specifiedCollection.next();
            if (this.contains(element)) {
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) throws NullPointerException {
        if (collection == null) {
            throw new NullPointerException("null passed as collection");
        }

        if (collection.isEmpty()) {
            return false;
        }

        for (E element : collection) {
           add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) throws NullPointerException, IndexOutOfBoundsException {
        if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        if (collection == null) throw new NullPointerException("null passed as collection");

        if (collection.isEmpty()) {
            return false;
        }

        for (E element : collection) {
            add(index, element);
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("null passed as collection");
        }

        if (collection.isEmpty()) {
            return false;
        }

        boolean didRemove = false;

        Iterator<E> collectionIterator = (Iterator<E>) collection.iterator();
        while (collectionIterator.hasNext()) {
            Object currentElement = collectionIterator.next();
            if (indexOf(currentElement) != -1) {
                remove(currentElement);
                didRemove = true;
            }
        }
        return didRemove;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("null passed as collection");
        }

        if (collection.isEmpty()) {
            return false;
        }

        boolean listHasChanged = false;

        ListIterator<E> listIterator = new MyListIterator();
        while (listIterator.hasNext()) {
            if (!collection.contains(listIterator.next())) {
                listIterator.remove();
                listHasChanged = true;
            }
        }

        return listHasChanged;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            StringBuilder returnString = new StringBuilder();
            Iterator<E> iterator = iterator();
            while (iterator.hasNext()) {
                returnString.append(iterator.next());
                if (iterator.hasNext()) {
                    returnString.append(", ");
                }
            }
            return "[" + returnString + "]";
        }
    }

    //Returns the element at the specified index in the list.
    //an error is thrown if index is not in range [0, size()-1]
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > size()-1 || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
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
    public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
        if (index > size()-1 || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        if (element == null) throw new NullPointerException("null passed as element");

        E originalElement;
        if (index == 0) {
            originalElement = head.getElement();
            head.setElement(element);
            return originalElement;
        }

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        originalElement = currentNode.getElement();
        currentNode.setElement(element);
        return originalElement;
    }

    //Removes and returns the element at index, moving all subsequent elements one index earlier in the list
    @Override
    public E remove(int index) {
        if (index > size()-1 || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        if (isEmpty()) return null;

        E removedElement;
        if (index == 0) {
            removedElement = head.getElement();
            head = head.getNext();
            size--;
            return removedElement;
        }

        Node<E> currentNode = head;
        Node<E> prevNode = currentNode;
        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        removedElement = currentNode.getElement();
        prevNode.setNext(currentNode.getNext());
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object object) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getElement().equals(object)) {
                    return index;
                }
            index++;
            currentNode = currentNode.getNext();
        }
        // if o is not in the list return -1
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!this.contains(object)) {
            return -1;
        }
        int index = 0;
        int lastIndex = index;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(object)) {
                lastIndex = index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return lastIndex;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            //by setting currentNode to head at start, don't have to check if null for hasNext...
            Node<E> currentNode = head;
            Node<E> prevNode = null;
            Boolean nextWasCalled = false;

            //...i.e. had if (currentNode.next != null) -> currentNode = head.
            //...but since return a boolean, and head already assigned, can just check if currentNode != null...
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (currentNode == null) {
                    throw new NoSuchElementException("No next element");
                }
                nextWasCalled = true;
                E answer = currentNode.getElement();
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                return answer;
            }

            @Override
            public void remove() {
                if (!nextWasCalled) { throw new IllegalStateException("next was not called prior to remove"); }
                SinglyLinkedListImpList.this.remove(prevNode.getElement());
                nextWasCalled = false;
            }
        };
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

//    @Override
//    public Spliterator<E> spliterator() {
//        return null;
//    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex > size() || fromIndex < 0 || fromIndex > toIndex || toIndex > size()) throw new IndexOutOfBoundsException("Index out of bounds");
        if (isEmpty()) return this;

        List<E> subList = new ArrayList();
        Iterator<E> iterator = iterator();
        for (int i = 0; i < fromIndex-1; i++) {
            iterator.next();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(iterator.next());
        }

        return subList;
    }

    @Override
    public Object[] toArray() {
        Object[] returnedArray = new Object[size()];
        Node currentNode = head;
        for (int i = 0; i < size(); i++) {
            returnedArray[i] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        return returnedArray;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        int size = size();
        //if passed in array is too small, instantiate new array
        if (array.length < size()) {
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
        } else if (array.length > size) {
            //if array is too large, set element immediately following the end of the list to null
            array[size] = null;
        }
        int i = 0;
        for (E element: this) {
            array[i] = (T) element;
            i++;
        }
        return array;
    }

    /**
     **
     ** Nested listIterator
     **
     **/
    private class MyListIterator implements ListIterator<E>, Serializable {
        private int selectedIndex = -1;
        private int nextIndex = 0;
        private int prevIndex = -1;

        public MyListIterator() {}

        public MyListIterator(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index > size()) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            this.nextIndex = index;
            this.prevIndex = index-1;
        }

        @Override
        public void add(E element) throws IllegalArgumentException {
            if (element == null) {
                throw new IllegalArgumentException("null element");
            }

            SinglyLinkedListImpList.this.add(nextIndex, element);
            nextIndex++;
            prevIndex++;
            selectedIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size();
        }

        @Override
        public boolean hasPrevious() {
            return prevIndex > -1;
        }

        @Override
        public E next() {
            if (nextIndex >= size()) {
                throw new NoSuchElementException("no next element");
            }
            selectedIndex = nextIndex;
            E answer = get(nextIndex);

            nextIndex++;
            prevIndex++;
            return answer;
        }

        @Override
        public int nextIndex() {
            if (nextIndex > size()) {
                return size();
            } else {
                return nextIndex;
            }
        }

        @Override
        public E previous() throws NoSuchElementException {
            if (prevIndex <= -1) {
                throw new NoSuchElementException("No previous element");
            }

            selectedIndex = prevIndex;
            E answer = get(prevIndex);    //get prev element to return;

            nextIndex--;
            prevIndex--;

            return answer;
        }

        @Override
        public int previousIndex() {
            return prevIndex;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (selectedIndex == -1) {
                throw new IllegalStateException("next or previous have not been called, or removed/add has been called since last next/previous call");
            }
            SinglyLinkedListImpList.this.remove(selectedIndex);
            selectedIndex = -1;
            nextIndex--;
            prevIndex--;
        }

        @Override
        public void set(E element) throws IllegalStateException {
            if (selectedIndex == -1) {
                throw new IllegalStateException("next or previous have not been called, or removed/add has been called since last next/previous call");
            }
            SinglyLinkedListImpList.this.set(selectedIndex, element);
            selectedIndex = -1;
        }
    }
}
