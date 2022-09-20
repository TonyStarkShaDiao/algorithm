package com.src.algorithm.datastructure.anarrayof.prod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertSortArrayTest {

    private InsertSortArray insertSortArrayUnderTest;

    @BeforeEach
    void setUp() {
        insertSortArrayUnderTest = new InsertSortArray();
    }

    @Test
    void testSortArray() {
        assertThat(insertSortArrayUnderTest.sortArray(new int[]{5, 7, 3, 8, 19})).isEqualTo(new int[]{0});
        assertThat(insertSortArrayUnderTest.sortArray(new int[]{0})).isEqualTo(new int[]{});
    }
}
