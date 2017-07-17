package com.timneville.Lists;

import com.google.common.collect.testing.ListTestSuiteBuilder;
import com.google.common.collect.testing.TestStringListGenerator;

import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.ListFeature;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

    @Test
    public TestSuite myListTestSuite() {
        return ListTestSuiteBuilder.using(
                // This class is responsible for creating the collection
                // And providing data, which can be put into the collection
                // Here we use a abstract generator which will create strings
                // which will be put into the collection
                new TestStringListGenerator() {
                    @Override
                    protected List<String> create(String[] elements) {
                        // Fill here your collection with the given elements
                        return new SinglyLinkedListImpList<String>(elements);
                    }
                })
                // The name of the test suite
                .named("My List Tests")
                // Here we give a hit what features our collection supports
                .withFeatures(ListFeature.GENERAL_PURPOSE,
                        CollectionFeature.ALLOWS_NULL_VALUES,
                        CollectionFeature.SERIALIZABLE,
                        CollectionFeature.FAILS_FAST_ON_CONCURRENT_MODIFICATION,
                        CollectionSize.ANY)
                .createTestSuite();
    }

}