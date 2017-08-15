package com.timneville.Sets;

import com.google.common.collect.testing.SetTestSuiteBuilder;
import com.google.common.collect.testing.TestStringSetGenerator;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.SetFeature;
import com.timneville.Sets.SetImp;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

import java.util.Set;

@RunWith(AllTests.class)
public class GuavaTestSuiteSet {

    public static TestSuite suite() {
        return SetTestSuiteBuilder.using(
                // Creates collection, and provides data to be put into the collection.

                // Then Abstract generator creates strings
                // which will be put into the collection
                new TestStringSetGenerator() {
                    @Override
                    protected Set<String> create(String[] elements) {
                        // Fill here your collection with the given elements
                        return new SetImp<>(elements);
                    }
                })
                // The name of the test suite
                .named("My Sets Tests")
                // Here we give a hit what features our collection supports
                .withFeatures(SetFeature.GENERAL_PURPOSE,
                        CollectionSize.ANY)
                .createTestSuite();
    }
}
