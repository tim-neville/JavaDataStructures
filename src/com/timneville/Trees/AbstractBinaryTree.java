package com.timneville.Trees;

import com.timneville.Lists.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timneville on 23/8/17.
 */

/**
 *  Abstract class defines implementation of accessor methods in context of a Binary Tree.
 *
 * */
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
    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void inorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        if (left(position) != null)
            inorderSubtree(left(position), snapshot);
        snapshot.add(position);
        if (right(position) != null)
            inorderSubtree(right(position), snapshot);
    }

    /** Returns an iterable collection of positions of the tree, 'inorder' order */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }

    /** Overrides positions to make 'inorder' the default order for binary trees */
    public Iterable<Position<E>> positions() {
        return inorder();
    }
}
