package com.timneville.Queues;

import java.util.Comparator;

/**
 * Created by timneville on 15/8/17.
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    private Comparator<K> comparator;

    //constructor taking a given comparator to order the keys...
    protected AbstractPriorityQueue(Comparator<K> comparator) { this.comparator = comparator; }
    //...otherwise -> natural ordering per default comparator class
    protected AbstractPriorityQueue() { this(new DefaultComparator<K>()); }

    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comparator.compare(key,key) == 0); //check if key can be compared to itself
        } catch (ClassCastException cce) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() { return size() == 0; }

    //--NESTED PQEntry--//
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }
        public K getKey() { return k; }
        public V getValue() { return v; }
        protected void setKey(K key) { k = key; }
        protected void setValue(V value) { v = value; }
    }
    //--END NESTED PQEntry--//
}
