package com.src.algorithm.datastructure.queue.test;

import com.src.algorithm.datastructure.queue.prod.TopKHighFrequencyElements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TopKHighFrequencyElementsTest {

    private TopKHighFrequencyElements topKHighFrequencyElementsUnderTest;

    @BeforeEach
    void setUp() {
        topKHighFrequencyElementsUnderTest = new TopKHighFrequencyElements();
    }

    @Test
    void testMySelf_QueueTopKHighFrequencyElements() {
        assertThat(topKHighFrequencyElementsUnderTest.mySelf_QueueTopKHighFrequencyElements(new int[]{0}, 0))
                .isEqualTo(new int[]{0});
        assertThat(topKHighFrequencyElementsUnderTest.mySelf_QueueTopKHighFrequencyElements(new int[]{0}, 0))
                .isEqualTo(new int[]{});
    }

    @Test
    void testBucketSort_QueueTopKHighFrequencyElements() {
        assertThat(topKHighFrequencyElementsUnderTest.bucketSort_QueueTopKHighFrequencyElements(new int[]{1, 1, 1, 2, 2, 3},
                2)).isEqualTo(new int[]{1, 2});
    }

    @Test
    void testTopKFrequent() {
        assertThat(topKHighFrequencyElementsUnderTest.topKFrequent(new int[]{1, 1, 1, 2, 2, 3},
                2)).isEqualTo(new int[]{1, 2}).isEqualTo(new int[]{0});
    }
}
