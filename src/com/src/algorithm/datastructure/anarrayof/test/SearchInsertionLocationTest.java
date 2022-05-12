package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SearchInsertionLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchInsertionLocationTest {

    private SearchInsertionLocation searchInsertionLocationUnderTest;
    private int[] needAnalysisArray;
    private int addElement;
    private int expectArrayIndex;

    @BeforeEach
    void setUp() {
        searchInsertionLocationUnderTest = new SearchInsertionLocation();
        needAnalysisArray = new int[]{1, 3, 5, 6};
        addElement = 2;
        expectArrayIndex = 1;
    }

    @Test
    void testBinarySearchSearchInsertionLocation() {
        assertThat(searchInsertionLocationUnderTest.binarySearchSearchInsertionLocation(needAnalysisArray, addElement)).isEqualTo(expectArrayIndex);
    }
}
