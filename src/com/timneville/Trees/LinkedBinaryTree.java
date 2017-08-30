package com.timneville.Trees;

import com.timneville.Lists.Position;

import java.util.Iterator;

/**
 * Created by timneville on 30/8/17.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {}

    /** Factory Function to create a new node storing element*/
    protected Node<E> createNode(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        return new Node<E>(element, parent, leftChild, rightChild);
    }

    //NON PUBLIC UTILITY METHOD
    /** Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }

        Node<E> node = (Node<E>) position;

        if (node.getParent() == node) {     //convention for a defunct node is when parent is set to itself.
            throw new IllegalArgumentException("position is no longer in the tree");
        }
        return node;
    }

    public Position<E> root() {
        return root;
    }

    public int size() {
        return size;
    }

    public Position<E> parent(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getParent();
    }
    public Position<E> left(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getLeftChild();
    }
    public Position<E> right(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getRightChild();
    }

    //Update Methods
    /** Places element at the root of an empty tree, and returns its new Position */
    public Position<E> addRoot(E element) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(element, null, null, null);
        size = 1;
        return root;
    }
    /** Creates a new left child of position */
    public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> parent = validate(position);
        if (parent.getLeftChild() != null)
            throw new IllegalArgumentException("position already has a left child");
        Node<E> child = createNode(element, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    /** Creates a new right child of position */
    public Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> parent = validate(position);
        if (parent.getRightChild() != null)
            throw new IllegalArgumentException("position already has a right child");
        Node<E> child = createNode(element, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    /** Replaces element at position with new element and returns the old element */
    public E setElement(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        E removedElement = node.getElement();
        node.setElement(element);
        return removedElement;
    }

    /** Attaches trees as left and right subtrees of external leaf position */
    public void attach(Position<E> position, LinkedBinaryTree<E> leftSubTree, LinkedBinaryTree<E> rightSubTree)
            throws IllegalArgumentException {
        Node<E> node = validate(position);
        if (isInternal(position)) throw new IllegalArgumentException("position must be a leaf");
        size += ( leftSubTree.size() + rightSubTree.size() );
        if (!leftSubTree.isEmpty()) {
            leftSubTree.root.setParent(node);
            node.setLeft(leftSubTree.root);
            leftSubTree.root = null;
            leftSubTree.size = 0;
        }
        if (!rightSubTree.isEmpty()) {
            rightSubTree.root.setParent(node);
            node.setRight(rightSubTree.root);
            rightSubTree.root = null;
            rightSubTree.size = 0;
        }
    }

    /** Removes the node at Position and replaces it with it's child, if any */
    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        if (numChildren(position) == 2) throw new IllegalArgumentException("position has two children");
        Node<E> child = (node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild()); //If left child not null then it will replace removed position, else right child will replace.
        if (child != null)
            child.setParent(node.getParent()); //child's grandparent becomes it's parent
        if (node == root)   //if the removed node is the root
            root = child;   //it's child becomes the new root.
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeftChild())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E removedElement = node.getElement();
        node.setElement(null);      //help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);       //defunct node convention that it's parent references itself.
        return removedElement;
    }

    Iterator<E> iterator() { return new ElementIterator(); };

    //------Nested ElementIterator class
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();
        @Override
        public boolean hasNext() { return positionIterator.hasNext(); }

        @Override
        public E next() { return positionIterator.next().getElement(); }

        public void remove() { positionIterator.remove(); }
    }

    //------NESTED NODE CLASS
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeftChild() { return leftChild; }
        public Node<E> getRightChild() { return rightChild; }

        public void setElement(E element) { this.element = element; }
        public void setParent(Node<E> parentNode) { this.parent = parentNode; }
        public void setLeft(Node<E> leftChild) { this.leftChild = leftChild; }
        public void setRight(Node<E> rightChild) { this.rightChild = rightChild; }
    }
}
