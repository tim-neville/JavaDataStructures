package com.timneville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 7/6/17.
 */
public class RecursionTest {
    private Recursion recursion;
    int[] data = new int[] {1,5,8,7,9,10,4,3,2,6};
    int index = 0;
    String stringInt = "900";

    @Before
    public void setUp() throws Exception {
        recursion = new Recursion();
    }

    @Test
    public void findMaxElementTest() throws Exception {
        assertEquals(10, recursion.findMaxElement(data, index));
    }

    @Test
    public void stringToIntegerTest() throws Exception {
        assertEquals(900, recursion.convertStringToInteger(stringInt));
    }

}