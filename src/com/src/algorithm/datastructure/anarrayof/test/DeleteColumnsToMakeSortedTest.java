package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.DeleteColumnsToMakeSorted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteColumnsToMakeSortedTest {

    private DeleteColumnsToMakeSorted deleteColumnsToMakeSortedUnderTest;
    private String[] characterStringArray;
    private int expectedValue;

    @BeforeEach
    void setUp() {
        deleteColumnsToMakeSortedUnderTest = new DeleteColumnsToMakeSorted();
        characterStringArray = new String[]{"cba", "daf", "ghi"};
        expectedValue = 1;
    }

    @Test
    void testMySelf_deleteColumnsToMakeSorted() {
        assertThat(deleteColumnsToMakeSortedUnderTest.mySelf_deleteColumnsToMakeSorted(characterStringArray)).isEqualTo(expectedValue);
    }
}
