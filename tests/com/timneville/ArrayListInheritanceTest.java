package com.timneville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 21/6/17.
 */
public class ArrayListInheritanceTest {
    ArrayListInheritance<String> testList;

    @Before
    public void setUp() throws Exception {
        testList = new ArrayListInheritance<>();
    }

    @Test
    public void addItems() throws Exception {
        testList.add("cars");
        testList.add("trucks");
        testList.add("bikes");

        assertEquals(true, testList.contains("cars"));
        assertEquals("cars", testList.get(0));
        assertEquals(2, testList.indexOf("bikes"));
        assertEquals(3, testList.size());
    }
}