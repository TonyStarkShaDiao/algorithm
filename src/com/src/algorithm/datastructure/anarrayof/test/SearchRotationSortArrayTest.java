package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SearchRotationSortArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchRotationSortArrayTest {

    private SearchRotationSortArray searchRotationSortArrayUnderTest;
    private int[] afterRotationArray;
    private int beforeRotationArrayElement;
    private int afterRotationArrayIndex;

    @BeforeEach
    void setUp() {
        searchRotationSortArrayUnderTest = new SearchRotationSortArray();
        afterRotationArray = new int[]{4, 5, 6, 7, 0, 1, 2};
        beforeRotationArrayElement = 0;
        afterRotationArrayIndex = 4;
    }

    @Test
    void testMySelf_DichotomySearchRotationSortArray() {
        assertThat(searchRotationSortArrayUnderTest.mySelf_DichotomySearchRotationSortArray(afterRotationArray, beforeRotationArrayElement))
                .isEqualTo(afterRotationArrayIndex);
    }
}
