package com.timneville.Maps;

import com.google.common.collect.testing.MapTestSuiteBuilder;
import com.google.common.collect.testing.TestStringMapGenerator;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.ListFeature;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

import java.util.Map;

@RunWith(AllTests.class)
public class GuavaTestSuiteMap {

    public static TestSuite suite() {
        return MapTestSuiteBuilder.using(
                // Creates collection, and provides data to be put into the collection.

                // Then Abstract generator creates strings
                // which will be put into the collection
                new TestStringMapGenerator() {
                    @Override
                    protected Map<String, String> create(Map.Entry<String, String>[] entries) {
                        // Fill here your collection with the given elements
                        return new HashMapImpMap<>(entries);
                    }
                })
                // The name of the test suite
                .named("My Map Tests")
                // Here we give a hit what features our collection supports
                .withFeatures(ListFeature.GENERAL_PURPOSE,
//                        CollectionFeature.ALLOWS_NULL_VALUES,
//                        CollectionFeature.SERIALIZABLE,
//                        CollectionFeature.FAILS_FAST_ON_CONCURRENT_MODIFICATION,
                        CollectionSize.ANY)
                .createTestSuite();
    }
}
