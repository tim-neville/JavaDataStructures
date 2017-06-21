package com.timneville;

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
    public void listIsEmpty() throws Exception {
        singlyLinkedList.isEmpty();

        assertTrue("is empty", singlyLinkedList.isEmpty());
        assertEquals("size is zero",0, singlyLinkedList.getSize());
        assertEquals("first node returns null", null, singlyLinkedList.getFirst());
        assertEquals("last node returns null", null, singlyLinkedList.getLast());
    }

    @Test
    public void addFirstOnEmptyList() throws Exception {

        //Act - call the method you want to test
        singlyLinkedList.addFirst(10);

        //Assert - assert what the result should be.
        assertEquals("first Node", 10, singlyLinkedList.getFirst());
        assertEquals("tail also points to head", 10, singlyLinkedList.getLast());
        assertFalse("is not empty after add", singlyLinkedList.isEmpty());
        assertEquals("size now 1", 1, singlyLinkedList.getSize());
    }

    @Test
    public void addLastOnEmptyList() throws Exception {
        singlyLinkedList.addLast(20);

        assertEquals("added Last", 20, singlyLinkedList.getLast());
        assertEquals("head also points to tail", 20, singlyLinkedList.getFirst());
        assertFalse("is not empty after add", singlyLinkedList.isEmpty());
        assertEquals("size now 1", 1, singlyLinkedList.getSize());
    }

    @Test
    public void removeFirstElement() throws Exception {
        singlyLinkedList.addFirst(10);
        singlyLinkedList.addFirst(20);
        singlyLinkedList.addFirst(30);

        assertEquals("remove and return First", 30, singlyLinkedList.removeFirst());
        assertEquals("size reduced by 1", 2, singlyLinkedList.getSize());
        assertEquals("new head is as expected", 20, singlyLinkedList.getFirst());
    }

    @Test
    public void removeNotLastElement() throws Exception {
        singlyLinkedList.addFirst(1);//Tail
        singlyLinkedList.addFirst(2);//<---Removing Not Last
        singlyLinkedList.addFirst(3);//Head

//        Object i1  = 7;
//        Object i2  = new Integer(7);
//        System.out.printf("i1 == i2 ? %b \ni1.equals(i2)? %b \n",i1 == i2, i1.equals(i2));

        assertEquals("removed value is correct",2, singlyLinkedList.removeWithValue(2));
        assertEquals("first is 3",3, singlyLinkedList.getFirst());
        assertEquals("last is 1",1, singlyLinkedList.getLast());
        assertEquals("check if 2 is actually gone",1, singlyLinkedList.getNextAfterHead());
    }

    @Test
    public void removeLastElement() throws Exception {
        singlyLinkedList.addFirst(1);//<---Removing last
        singlyLinkedList.addFirst(2);//Tail
        singlyLinkedList.addFirst(3);//Head

        assertEquals("removed value is correct",1, singlyLinkedList.removeWithValue(1));
        assertEquals("first is 3",3, singlyLinkedList.getFirst());
        assertEquals("last is 2",2, singlyLinkedList.getLast());
        assertEquals("check if 1 is actually gone",2, singlyLinkedList.getNextAfterHead());
    }
}