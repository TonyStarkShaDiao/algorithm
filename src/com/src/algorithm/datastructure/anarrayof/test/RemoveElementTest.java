package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.RemoveElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementTest {

    private RemoveElement removeElementUnderTest;
    private int[] nums;
    private int expectArrayLength;
    private int removeElement;

    @BeforeEach
    void setUp() {
        removeElementUnderTest = new RemoveElement();
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        removeElement = 2;
        expectArrayLength = 5;
    }

    @Test
    void testRemoveElement() {
        assertThat(removeElementUnderTest.removeElement(nums, removeElement)).isEqualTo(expectArrayLength);
    }
}
