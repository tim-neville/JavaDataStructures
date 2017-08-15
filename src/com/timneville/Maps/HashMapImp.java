package com.timneville.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by timneville on 15/8/17.
 */
public class HashMapImp<K,V> implements Map<K,V> {
    public HashMapImp(Map.Entry<K, V>[] entries) throws IllegalArgumentException {
        putAll(entries);
    }

    private void putAll(Entry<K, V>[] entries) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
