package com.timneville.Maps;

import com.timneville.Lists.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

/**
 * Created by timneville on 15/8/17.
 */
public class HashMapImpMap<K,V> implements Map<K,V> {
    private SinglyLinkedListImpList[] hashArray;
    private int arraySize = 0;
    private int numEntries = 0;

    public HashMapImpMap(int size) {
        arraySize = size;
        hashArray = new SinglyLinkedListImpList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SinglyLinkedListImpList();
        }
    }

    public HashMapImpMap(Map.Entry<K, V>[] entries) throws IllegalArgumentException {
        arraySize = entries.length;
        hashArray = new SinglyLinkedListImpList[entries.length];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SinglyLinkedListImpList();
        }
        for (Entry<K, V> each : entries) {
            put(each.getKey(), each.getValue());
        }
    }

    private int hashValue(Object key) {
        return ((Math.abs(key.hashCode()) % 109345121) % arraySize);
    }

    @Override
    public int size() {
        return numEntries;
    }

    @Override
    public boolean isEmpty() {
        return numEntries == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hashCode = hashValue(key);
        Iterator iterator = hashArray[hashCode].iterator();
            while (iterator.hasNext()) {
                MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
                if (currentEntry.getKey().equals(key)) {
                    return true;
                }
            }
            return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (SinglyLinkedListImpList each : hashArray) {
            Iterator iterator = each.iterator();
            while (iterator.hasNext()) {
                MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
                if (currentEntry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) throws NullPointerException {
        if (key == null) { throw new NullPointerException("null passed as key"); }

        int hashCode = hashValue(key);
        Iterator iterator = hashArray[hashCode].iterator();
        while (iterator.hasNext()) {
            MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
            if (currentEntry.getKey().equals(key)) {
                return currentEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = hashValue(key);
        hashArray[hashCode].add(new MapEntry<>(key, value));
        numEntries++;
        return value;
    }

    @Override
    public V remove(Object key) {
        int hashCode = hashValue(key);
        Iterator iterator = hashArray[hashCode].iterator();
        SinglyLinkedListImpList currentList = hashArray[hashCode];
        while (iterator.hasNext()) {
            MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
            if (currentEntry.getKey().equals(key)) {
                V removedEntry = currentEntry.getValue();
                currentList.remove(currentEntry);
                return removedEntry;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<K> mapKeySet = (Set<K>) m.keySet();
        for (K each : mapKeySet) {
            this.put(each, m.get(each));
        }
    }

    @Override
    public void clear() {
        for (SinglyLinkedListImpList each : hashArray) {
            each.clear();
        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> collection = new ArrayList<>();
        for (SinglyLinkedListImpList each : hashArray) {
            Iterator iterator = each.iterator();
            while (iterator.hasNext()) {
                MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
                collection.add(currentEntry.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    //--nested MapEntry class--//
    public static class MapEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;
        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }

        //utilities
        public void setKey(K key) { this.key = key; }
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    } //--end nested MapEntry class --//
}
