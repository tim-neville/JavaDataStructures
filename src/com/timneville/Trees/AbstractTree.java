package com.timneville.Trees;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;
import com.timneville.Lists.Position;
import com.timneville.Queues.LinkedQueue;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by timneville on 23/8/17.
 */

/** AbstractTree defines implementation of the basic Tree utility methods */

public abstract class AbstractTree<E> implements TreeADT<E> {
    public boolean isInternal(Position<E> position) { return numChildren(position) > 0; }
    public boolean isExternal(Position<E> position) { return numChildren(position) == 0; }
    public boolean isRoot(Position<E> position) { return position == root(); }
    public boolean isEmpty() { return size() == 0; }

    /** Returns iterable collection of tree positions, in pre-order */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);  // fill the snapshot recursively.
        return snapshot;
    }

    /** From the passed in position, adds positions of subtrees recursively, to the given snapshot */
    private void preorderSubtree(Position <E> position, List<Position<E>> snapshot) {
        snapshot.add(position); //pre-order adds visited position BEFORE traversing subtrees
        for (Position<E> child : children(position))
            preorderSubtree(child, snapshot);
    }

    /** Returns iterable collection of tree positions, in post-order */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot); //fill snapshot recursively.
        return snapshot;
    }

    /** From the passed in position, adds positions of subtrees recursively, to the given snapshot */
    private void postorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        for (Position<E> child : children(position))
            postorderSubtree(child, snapshot);
        snapshot.add(position); //post-order adds visited position AFTER traversing subtrees
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedTransferQueue<>();
            fringe.add(root());
            while(!fringe.isEmpty()) {
                Position<E> position = fringe.remove();
                snapshot.add(position);
                for (Position<E> child : children(position))
                    fringe.add(child);
            }
        }
        return snapshot;
    }
}
