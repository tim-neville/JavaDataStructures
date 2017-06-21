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
    public void addNewItem() throws Exception {
        myList.add("Object 1");
        myList.add("Object 2");
        myList.add("Object 3");
        myList.add("Object 4");
        myList.add("Object 5");

        assertEquals("Object 1", myList.getFirst());
        assertEquals("Object 5", myList.getLast());
        assertEquals("Object 1", myList.get(0));
        assertEquals("Object 2", myList.get(1));
        assertEquals("Object 3", myList.get(2));
        assertEquals("Object 4", myList.get(3));
        assertEquals("Object 5", myList.get(4));
        assertEquals(5, myList.size());
    }

    @Test
    public void clearedListIsEmpty() throws Exception {
        myList.add("Object 1");
        myList.add("Object 2");
        myList.add("Object 3");
        myList.add("Object 4");
        myList.add("Object 5");
        myList.clear();

        assertEquals(0, myList.size());
        assertEquals(false, myList.contains("Object 3"));
    }

}