package com.timneville.Trees;

import com.timneville.Lists.Position;

import java.util.Iterator;

/**
 * Created by timneville on 23/8/17.
 */

/** TreeADT declares accessor and utility methods of a Tree */

public interface TreeADT<E> extends Iterable<E> {
    Position<E> root();

    Position<E> parent(Position<E> position) throws IllegalArgumentException;

    Iterable<Position<E>> children(Position<E> position) throws IllegalArgumentException;

    int numChildren(Position<E> position) throws IllegalArgumentException;

    boolean isInternal(Position<E> position) throws IllegalArgumentException;

    boolean isExternal(Position<E> position) throws IllegalArgumentException;

    boolean isRoot(Position<E> position) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
