package com.timneville.Maps;

import com.timneville.Lists.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by timneville on 15/8/17.
 */
public class HashMapImpMap<K,V> implements Map<K,V> {
    private SinglyLinkedListImpList[] hashArray;
    private final int arraySize = 13;
    private int numEntries = 0;

    public HashMapImpMap() {
        hashArray = new SinglyLinkedListImpList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SinglyLinkedListImpList();
        }
    }

    public HashMapImpMap(Map.Entry<K, V>[] entries) throws IllegalArgumentException {
        this();
        for (Entry<K, V> each : entries) {
            put(each.getKey(), each.getValue());
        }
    }

    private int hashValue(Object key) {
        return key.hashCode() % arraySize;
    }

/**    @Override
    public int hashCode() {
        int sum;
        for (Set<K, V> each : entrySet()) {
            sum += each;
        }

        return entrySet().hashCode();
    }*/

    @Override
    public int size() {
        return numEntries;
    }

    @Override
    public boolean isEmpty() {
        return numEntries == 0;
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException {
        if (isEmpty()) return false;

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
public boolean equals(Object obj) {
        return obj.equals(this);
        }

    @Override
    public V get(Object key) throws NullPointerException {
        if (key == null) { throw new NullPointerException("null passed as key"); }
        if (isEmpty()) return null;

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
    public V put(K key, V value) throws NullPointerException {
        if (key == null || value == null) throw new NullPointerException("null passed in");

        if (isEmpty()) {}

        /**
         *
         * Need dynamic re-sizing of array
         *
         * */

        int hashCode = hashValue(key);
        hashArray[hashCode].add(new MapEntry<>(key, value));
        numEntries++;
        return value;
    }

    @Override
    public V remove(Object key) {
        if (isEmpty()) return null;

        int hashCode = hashValue(key);
        Iterator iterator = hashArray[hashCode].iterator();
        SinglyLinkedListImpList currentList = hashArray[hashCode];
        while (iterator.hasNext()) {
            MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
            if (currentEntry.getKey().equals(key)) {
                V removedEntry = currentEntry.getValue();
                currentList.remove(currentEntry);
                numEntries--;
                return removedEntry;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) throws NullPointerException {
        if (m == null) throw new NullPointerException("null passed as map");

        Set<K> mapKeySet = (Set<K>) m.keySet();
        for (K each : mapKeySet) {
            put(each, m.get(each));
        }
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (SinglyLinkedListImpList each : hashArray) {
                each.clear();
            }
            numEntries = 0;
        }
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet();
        for (SinglyLinkedListImpList each : hashArray) {
            Iterator iterator = each.iterator();
            while (iterator.hasNext()) {
                MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
                set.add(currentEntry.getKey());
            }
        }
        return set;
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
        HashSet set = new HashSet();
        for (SinglyLinkedListImpList each : hashArray) {
            Iterator iterator = each.iterator();
            while (iterator.hasNext()) {
                MapEntry<K,V> currentEntry = (MapEntry<K, V>) iterator.next();
                set.add(currentEntry);
            }
        }
        return set;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) throws UnsupportedOperationException {
        if (key == null) throw new NullPointerException("Null passed as key");
        if (get(key) == null) {
            V value = mappingFunction.apply(key);
            if (value == null) { return null; }
            return put(key, value);
        } else {
            return null;
        }
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException("merge not supported");
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
