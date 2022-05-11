package com.src.algorithm.datastructure.queue.test;

import com.src.algorithm.datastructure.queue.prod.TheKthLargestElementInTheArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheKthLargestElementInTheArrayTest {

    private TheKthLargestElementInTheArray theKthLargestElementInTheArrayUnderTest;
    private int[] needFindArray;
    private int whatIsLargestElement;
    private int expectedValue;

    @BeforeEach
    void setUp() {
        theKthLargestElementInTheArrayUnderTest = new TheKthLargestElementInTheArray();
        needFindArray = new int[]{3, 2, 1, 5, 6, 4};
        whatIsLargestElement = 2;
        expectedValue = 5;
    }

    @Test
    void testFindKthLargest() {
        assertThat(theKthLargestElementInTheArrayUnderTest.myself_findKthLargest(needFindArray, whatIsLargestElement)).isEqualTo(expectedValue);
    }
}
