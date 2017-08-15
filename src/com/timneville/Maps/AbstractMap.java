package com.timneville.Maps;

import java.util.Iterator;

/**
 * Created by timneville on 15/8/17.
 */
public abstract class AbstractMap<K,V> implements MapADT<K,V> {
    public boolean isEmpty() { return size() == 0; }

    public Iterable<K> keySet() { return new KeyIterable(); }

    public Iterable<V> values() { return new ValueIterable(); }

    //--nested KeyIterator to support keySet method
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() { return new KeyIterator(); }
    }

    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() { return entries.hasNext(); }
        public K next() { return entries.next().getKey(); }
        public void remove() { throw new UnsupportedOperationException(); }
    }

    //--nested ValueIterator to support values method
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() { return new ValueIterator(); }
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() { return entries.hasNext(); }
        public V next() { return entries.next().getValue(); }
        public void remove() { throw new UnsupportedOperationException(); }
    }

    //--nested MapEntry class--//
    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;
        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }

        //utilities
        protected void setKey(K key) { this.key = key; }
        protected V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    } //--end nested MapEntry class --//
}
