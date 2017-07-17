package com.timneville.Lists;

import org.junit.Before;
import org.junit.Test;


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
        public void containsElementsAfterAdding() throws Exception {
            myList.add("Bike");
            myList.add("Dog");

            assertEquals("contains Bike test", true, myList.contains("Bike"));
            assertEquals(false, myList.contains("Cat"));
            assertEquals(2, myList.size());
        }

        @Test
        public void iteratorOnEmptyListDoesNotHaveNext() throws Exception {
            assertEquals(false, myList.iterator().hasNext());
        }

        @Test
        public void iteratorReturnsNext() throws Exception {
            myList.add("Bike");
            myList.add("Dog");

            assertEquals("Bike", myList.iterator().next());
            assertFalse(myList.iterator().next() == "Dog");
        }

        @Test
        public void listContainsElementsAfterAddAtIndex() throws Exception {
            myList.add("Frogs");
            myList.add("Logs");
            myList.add("Planes");
            myList.add("Trains");
            //myList.add(1, "Dogs");

            //assertEquals("testAtIndex Dogs",true, myList.contains("Dogs"));
            //assertEquals("testAdd Planes", true, myList.contains("Planes"));
        }
}