package com.timneville.Queues;

import java.util.Comparator;

/**
 * Created by timneville on 15/8/17.
 */

//Assuming keys come from a comparable class, natural ordering as a default comparator for priorityQueue class.
public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
