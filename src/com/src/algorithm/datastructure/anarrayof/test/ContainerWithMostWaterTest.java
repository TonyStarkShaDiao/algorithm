package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ContainerWithMostWater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWaterUnderTest;
    private int[] containerHeightArray;
    private int expectedValue;

    @BeforeEach
    void setUp() {
        containerWithMostWaterUnderTest = new ContainerWithMostWater();
        containerHeightArray = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        expectedValue = 49;
    }

    @Test
    void testMaxArea() {
        assertThat(containerWithMostWaterUnderTest.maxArea(containerHeightArray)).isEqualTo(expectedValue);
    }
}
