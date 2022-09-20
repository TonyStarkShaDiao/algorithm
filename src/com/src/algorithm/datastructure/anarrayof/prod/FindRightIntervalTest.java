package com.src.algorithm.datastructure.anarrayof.prod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindRightIntervalTest {

    private FindRightInterval findRightIntervalUnderTest;

    @BeforeEach
    void setUp() {
        findRightIntervalUnderTest = new FindRightInterval();
    }

    @Test
    void testFindRightInterval() {
        // Setup
        final int[][] intervals = new int[][]{{4, 5}, {2, 3}, {1, 2}};

        // Run the test
        final int[] result = findRightIntervalUnderTest.findRightInterval(intervals);

        // Verify the results
        assertThat(result).isEqualTo(new int[]{0});
    }
}
