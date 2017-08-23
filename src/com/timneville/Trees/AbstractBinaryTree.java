package com.timneville.Trees;

import com.timneville.Lists.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timneville on 23/8/17.
 */

/** An abstract base class providing some functionality of the BinaryTree interface */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTreeADT<E> {

    public Position<E> sibling(Position<E> position) {
        Position<E> parent = parent(position);
        if (parent == null) return null;
        if (position == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Position<E> position) {
        int count = 0;
        if (left(position) != null)
            count++;
        if (right(position) != null)
            count++;
        return count;
    }

    public Iterable<Position<E>> children(Position<E> position) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(position) != null)
            snapshot.add(left(position));
        if (right(position) != null)
            snapshot.add(right(position));
        return snapshot;
    }
}
