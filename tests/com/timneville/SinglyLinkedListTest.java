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
        assertEquals("first node returns null", null, singlyLinkedList.ElementAtFirstNode());
        assertEquals("last node returns null", null, singlyLinkedList.ElementAtLastNode());
    }

    @Test
    public void nodeAddToHeadOfEmptyList() throws Exception {
        //Act - call the method you want to test
        singlyLinkedList.addFirst(10);

        //Assert - assert what the result should be.
        assertEquals("add First", 10, singlyLinkedList.ElementAtFirstNode());
        assertEquals("tail also points to head", 10, singlyLinkedList.ElementAtLastNode());
        assertFalse("is not empty after add", singlyLinkedList.isEmpty());
        assertEquals("size now 1", 1, singlyLinkedList.getSize());
    }

    @Test
    public void nodeAddToTail() throws Exception {
        singlyLinkedList.addLast(20);

        assertEquals("added Last", 20, singlyLinkedList.ElementAtLastNode());
        assertEquals("head also points to tail", 20, singlyLinkedList.ElementAtFirstNode());
        assertFalse("is not empty after add", singlyLinkedList.isEmpty());
        assertEquals("size now 1", 1, singlyLinkedList.getSize());
    }

    @Test
    public void removeFirstNode() throws Exception {
        singlyLinkedList.addFirst(10);
        singlyLinkedList.addFirst(20);
        singlyLinkedList.addFirst(30);

        assertEquals("remove and return First", 30, singlyLinkedList.removeFirst());
        assertEquals("size reduced by 1", 2, singlyLinkedList.getSize());
        assertEquals("new head is as expected", 20, singlyLinkedList.ElementAtFirstNode());
    }

    @Test
    public void removeWithValueTest() throws Exception {
        singlyLinkedList.addFirst(1);//Tail
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);//Head

        assertEquals(3, singlyLinkedList.removeWithValue(3));
    }

//    @Test
//    public void removeWithValueTail() throws Exception {
//        singlyLinkedList.addFirst(1);
//        singlyLinkedList.addFirst(2);
//        singlyLinkedList.addFirst(3);
//        singlyLinkedList.removeWithValue(1);
//
//        assertEquals("last node as expected after remove value", 2, singlyLinkedList.ElementAtLastNode());
//        assertEquals("first node as expected after remove value", 3, singlyLinkedList.ElementAtFirstNode());
//    }
//
//    @Test
//    public void removeWithValueReturnsAValue() throws Exception {
//        singlyLinkedList.addFirst(1);
//        singlyLinkedList.addFirst(2);
//        singlyLinkedList.addFirst(3);
//        singlyLinkedList.removeWithValue(2);
//
//        assertEquals("last node as expected after remove value", 1, singlyLinkedList.ElementAtLastNode());
//        assertEquals("first node as expected after remove value", 3, singlyLinkedList.ElementAtFirstNode());
//    }
}