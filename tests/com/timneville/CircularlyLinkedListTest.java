package com.timneville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 21/6/17.
 */
public class CircularlyLinkedListTest {
    CircularlyLinkedList<String> circularlyLinkedList;

    @Before
    public void setUp() throws Exception {
        circularlyLinkedList = new CircularlyLinkedList<>();
    }

    @Test
    public void addNewLink() throws Exception {
        circularlyLinkedList.add("Object 1");

        assertEquals("Object 1", circularlyLinkedList.getFirst());
    }
}