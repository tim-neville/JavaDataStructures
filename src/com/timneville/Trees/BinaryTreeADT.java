package com.timneville.Trees;

/**
 * Created by timneville on 23/8/17.
 */

import com.timneville.Lists.Position;

/** BinaryTree - each node has at most two children
 *
 * This BinaryTreeADT adds three new behaviours to the base interface TreeADT
 *
 * */
public interface BinaryTreeADT<E> extends TreeADT<E> {
    Position<E> left(Position<E> position) throws IllegalArgumentException;
    Position<E> right(Position<E> position) throws IllegalArgumentException;
    Position<E> sibling(Position<E> position) throws IllegalArgumentException;
}
