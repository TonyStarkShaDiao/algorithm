package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.FindsFirstAndLastPositionsOfAnElementInASortedArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindsFirstAndLastPositionsOfAnElementInASortedArrayTest {

    private FindsFirstAndLastPositionsOfAnElementInASortedArray findsFirstAndLastPositionsOfAnElementInASortedArrayUnderTest;
    int[] needAnalysisArray;
    int needFindElement;

    @BeforeEach
    void setUp() {
        findsFirstAndLastPositionsOfAnElementInASortedArrayUnderTest = new FindsFirstAndLastPositionsOfAnElementInASortedArray();
        needAnalysisArray = new int[]{5, 7, 7, 8, 8, 10};
        needFindElement = 8;
    }

    @Test
    void testMyself_SearchRange() {
        assertThat(findsFirstAndLastPositionsOfAnElementInASortedArrayUnderTest.myself_SearchRange(needAnalysisArray,
                needFindElement)).isEqualTo(new int[]{0});

    }
}
