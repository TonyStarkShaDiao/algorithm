package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.nodes.prod.LRUCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    private LRUCache lruCacheUnderTest;
    private int initialCapacity;
    private int expectCollectionSize;
    private int expectNodeValue;

    @BeforeEach
    void setUp() {
        initialCapacity = 2;
        expectCollectionSize = -1;
        expectNodeValue = 3;
        lruCacheUnderTest = new LRUCache(initialCapacity);
    }

    @Test
    void testGet() {
        final int result = lruCacheUnderTest.get(0);
        assertThat(result).isEqualTo(expectCollectionSize);
    }

    @Test
    void testPut() {
        lruCacheUnderTest.put(3, 3);
        assertThat(lruCacheUnderTest.get(3)).isEqualTo(expectNodeValue);
    }
}
