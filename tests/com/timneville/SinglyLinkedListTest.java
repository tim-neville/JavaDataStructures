package com.timneville;

import com.timneville.Lists.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 31/5/17.
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList singlyLinkedList;

    @Before
    public void setUp() throws Exception {
        singlyLinkedList = new SinglyLinkedList();
    }

    @Test
    public void removeWithValueReturnsRemovedElement() throws Exception {
        singlyLinkedList.addFirst(1);//Tail
        singlyLinkedList.addFirst(2);//<---Removing Not Last
        singlyLinkedList.addFirst(3);//Head

        assertEquals("removed value",2, singlyLinkedList.removeWithValue(2));
        assertEquals("first element as expected",3, singlyLinkedList.getFirst());
        assertEquals("last element as expected",1, singlyLinkedList.getLast());

        singlyLinkedList.clear();

        singlyLinkedList.addFirst(1);//<---Removing last
        singlyLinkedList.addFirst(2);//Tail
        singlyLinkedList.addFirst(3);//Head

        assertEquals("removed value is correct",1, singlyLinkedList.removeWithValue(1));
        assertEquals("first element as expected",3, singlyLinkedList.getFirst());
        assertEquals("last element as expected",2, singlyLinkedList.getLast());

        singlyLinkedList.clear();

        singlyLinkedList.addFirst(1);//Tail
        singlyLinkedList.addFirst(2);//Head
        singlyLinkedList.addFirst(3);//<---Removing first

        assertEquals("removed value is correct",3, singlyLinkedList.removeWithValue(3));
        assertEquals("first element as expected",2, singlyLinkedList.getFirst());
        assertEquals("last element as expected",1, singlyLinkedList.getLast());
    }

}