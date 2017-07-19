package com.timneville.Queues;

/**
 * Created by timneville on 29/6/17.
 */

/** Queue ADT **/

public interface QueueInterfaceADT<E> {
    /**@return the number of elements in the stack**/
    int size();
    /**@return true if the stack is empty**/
    boolean isEmpty();
    /**@param element to be inserted at back of the queue**/
    void enqueue(E element);
    /**@return but doesn't remove, the first element of the queue (null if empty)**/
    E first();
    /**@return and remove element from the front of the queue **/
    E dequeue();
}
