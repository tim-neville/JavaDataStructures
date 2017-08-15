package com.timneville.Queues;

/**
 * Created by timneville on 15/8/17.
 */
public interface Entry<K,V> {
    K getKey();
    V getValue();
}
