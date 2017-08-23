package com.timneville.Trees;

import com.timneville.Lists.Position;

/**
 * Created by timneville on 23/8/17.
 */
public abstract class AbstractTree<E> implements TreeADT<E> {
    public boolean isInternal(Position<E> position) { return numChildren(position) > 0; }
    public boolean isExternal(Position<E> position) { return numChildren(position) == 0; }
    public boolean isRoot(Position<E> position) { return position == root(); }
    public boolean isEmpty() { return size() == 0; }
}
