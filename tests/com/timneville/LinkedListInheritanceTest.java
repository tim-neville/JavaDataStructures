package com.timneville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 21/6/17.
 */
public class LinkedListInheritanceTest {
    LinkedListInheritance<String> myList;

    @Before
    public void setUp() throws Exception {
        myList = new LinkedListInheritance<>();
    }

    @Test
    public void addItems() throws Exception {
        myList.add("cars");
        myList.add("trucks");
        myList.add("bikes");

        assertEquals(true, myList.contains("cars"));
        assertEquals("cars", myList.get(0));
        assertEquals(2, myList.indexOf("bikes"));
        assertEquals(3, myList.size());
    }
}