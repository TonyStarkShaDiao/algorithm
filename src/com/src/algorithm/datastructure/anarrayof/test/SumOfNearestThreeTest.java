package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SumOfNearestThree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfNearestThreeTest {

    private SumOfNearestThree sumOfNearestThreeUnderTest;
    private int[] needAnalysisArray;
    private int closestValue;

    private int expectedValue;

    @BeforeEach
    void setUp() {
        sumOfNearestThreeUnderTest = new SumOfNearestThree();
        needAnalysisArray = new int[]{1, 2, 3, 5};
        closestValue = 3;
        expectedValue = 6;
    }

    @Test
    void testMySelf_DoubleSumOfNearestThree() {
        assertThat(sumOfNearestThreeUnderTest.mySelf_DoubleSumOfNearestThree(needAnalysisArray, closestValue)).isEqualTo(expectedValue);
    }
}
