package com.timneville.Maps;

/**
 * Created by timneville on 14/8/17.
 */
public interface MapADT<K,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K,V>> entrySet();
}