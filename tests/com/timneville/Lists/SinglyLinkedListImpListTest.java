package com.timneville.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by timneville on 5/7/17.
 */
public class SinglyLinkedListImpListTest {
    private SinglyLinkedListImpList myList;

    @Before
    public void setUp() throws Exception {
        myList = new SinglyLinkedListImpList();
    }

    @Test
    public void contains() throws Exception {
        myList.add("Bike");
        myList.add("Dog");

        assertEquals(true, myList.contains("Bike"));
        assertEquals(false, myList.contains("Cat"));
        assertEquals(2, myList.size());
    }

    @Test
    public void iteratorEmptyList() throws Exception {
        assertEquals(false, myList.iterator().hasNext());
    }

    @Test
    public void iteratorReturnsNext() throws Exception {
        myList.add("Bike");
        myList.add("Dog");

        assertEquals("Bike", myList.iterator().next());
        assertFalse(myList.iterator().next() == "Dog");

    }
}