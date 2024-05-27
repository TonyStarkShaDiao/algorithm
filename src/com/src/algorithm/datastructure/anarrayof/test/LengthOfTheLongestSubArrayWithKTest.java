package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.LengthOfTheLongestSubArrayWithK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfTheLongestSubArrayWithKTest {

    private LengthOfTheLongestSubArrayWithK lengthOfTheLongestSubArrayWithKUnderTest;

    @BeforeEach
    void setUp() {
        lengthOfTheLongestSubArrayWithKUnderTest = new LengthOfTheLongestSubArrayWithK();
    }

    @Test
    void testMaxSubArrayLen() {
        assertThat(lengthOfTheLongestSubArrayWithKUnderTest.maxSubArrayLen(new int[]{0}, 0)).isEqualTo(0);
    }

    @Test
    void testMaxSubArrayLen_V2() {
        assertThat(lengthOfTheLongestSubArrayWithKUnderTest.maxSubArrayLen_V2(new int[]{0}, 0)).isEqualTo(0);
    }
}
