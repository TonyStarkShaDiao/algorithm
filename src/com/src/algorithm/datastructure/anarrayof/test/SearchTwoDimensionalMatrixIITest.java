package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.SearchTwoDimensionalMatrixII;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTwoDimensionalMatrixIITest {
  SearchTwoDimensionalMatrixII searchTwoDimensionalMatrixII;
  int [][] TwoDimensionalMatrix;
  int containsTargetValue;
  int notContainsTargetValue;

    @BeforeEach
    void setUp() {
        notContainsTargetValue = -1;
        containsTargetValue = 5;
        TwoDimensionalMatrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        searchTwoDimensionalMatrixII =new SearchTwoDimensionalMatrixII();
    }

    @AfterEach
    void tearDown() {
    }
    @DisplayName("Test for search target value in 2D matrix for contains")
    @Test
    void mySelf_searchTwoDimensionMatrixForContains() {
        Boolean checkResult = searchTwoDimensionalMatrixII.mySelf_searchTwoDimensionMatrix(TwoDimensionalMatrix, containsTargetValue);
        assertTrue(checkResult);
    }
    @DisplayName("Test for search target value in 2D matrix for not contains")
    @Test
    void mySelf_searchTwoDimensionMatrixForNotContains() {
        Boolean checkResult = searchTwoDimensionalMatrixII.mySelf_searchTwoDimensionMatrix(TwoDimensionalMatrix, notContainsTargetValue);
        assertFalse(checkResult);
    }
}