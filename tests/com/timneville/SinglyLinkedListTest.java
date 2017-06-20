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
        assertEquals("first node returns null", null, singlyLinkedList.elementAtFirstNode());
        assertEquals("last node returns null", null, singlyLinkedList.elementAtLastNode());
    }

    @Test
    public void addNodeToHeadOfEmptyList() throws Exception {

        //Act - call the method you want to test
        singlyLinkedList.addFirst(10);

        //Assert - assert what the result should be.
        assertEquals("first Node", 10, singlyLinkedList.elementAtFirstNode());
        assertEquals("tail also points to head", 10, singlyLinkedList.elementAtLastNode());
        assertFalse("is not empty after add", singlyLinkedList.isEmpty());
        assertEquals("size now 1", 1, singlyLinkedList.getSize());
    }

    @Test
    public void nodeAddToTail() throws Exception {
        singlyLinkedList.addLast(20);

        assertEquals("added Last", 20, singlyLinkedList.elementAtLastNode());
        assertEquals("head also points to tail", 20, singlyLinkedList.elementAtFirstNode());
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
        assertEquals("new head is as expected", 20, singlyLinkedList.elementAtFirstNode());
    }

    @Test
    public void removeHeadReturnsHead() throws Exception {
        singlyLinkedList.addFirst(1);//Tail
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);//Head

        assertEquals(3, singlyLinkedList.removeWithValue(3));
        assertEquals(2, singlyLinkedList.elementAtFirstNode());
        assertEquals(1, singlyLinkedList.elementAtLastNode());
    }

    @Test
    public void removeTailReturnsTail() throws Exception {
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);

//        Object i1  = 7;
//        Object i2  = new Integer(7);
//        System.out.printf("i1 == i2 ? %b \ni1.equals(i2)? %b \n",i1 == i2, i1.equals(i2));

        assertEquals(1, singlyLinkedList.removeWithValue(1));
        assertEquals(3, singlyLinkedList.elementAtFirstNode());
        assertEquals(2, singlyLinkedList.elementAtLastNode());
    }
}