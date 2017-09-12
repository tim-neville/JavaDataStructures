package com.timneville.Trees;

import com.timneville.Lists.Position;

/**
 * Created by timneville on 23/8/17.
 */

/** BinaryTree - each node has at most two children
 *
 * BinaryTreeADT extends Tree definition, declares three additional accessor methods relevant to a Binary Tree.
 *
 * */
public interface BinaryTreeADT<E> extends TreeADT<E> {
    Position<E> left(Position<E> position) throws IllegalArgumentException;
    Position<E> right(Position<E> position) throws IllegalArgumentException;
    Position<E> sibling(Position<E> position) throws IllegalArgumentException;
}
