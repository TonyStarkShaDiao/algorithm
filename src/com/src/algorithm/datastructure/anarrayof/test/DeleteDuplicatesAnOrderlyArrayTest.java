package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.DeleteDuplicatesAnOrderlyArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteDuplicatesAnOrderlyArrayTest {

    private DeleteDuplicatesAnOrderlyArray deleteDuplicatesAnOrderlyArrayUnderTest;
    private int[] repeatingElementArray;
    private int expectArrayLength;

    @BeforeEach
    void setUp() {
        deleteDuplicatesAnOrderlyArrayUnderTest = new DeleteDuplicatesAnOrderlyArray();
        repeatingElementArray = new int[]{1, 2, 2, 3, 4, 5};
        expectArrayLength = 5;
    }

    @Test
    void testMySelf_doublePoint() {
        assertThat(deleteDuplicatesAnOrderlyArrayUnderTest.mySelf_doublePoint(repeatingElementArray)).isEqualTo(expectArrayLength);
    }
}
