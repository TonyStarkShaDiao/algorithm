package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.PascalsTriangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleTest {

    PascalsTriangle pascalsTriangle;
    List<List<Integer>> pascalsTriangleResultCollection;
    @BeforeEach
    void setUp() {
//        [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        pascalsTriangle = new PascalsTriangle();
        pascalsTriangleResultCollection = new ArrayList<>();
        pascalsTriangleResultCollection.add(0, Arrays.asList(1));
        pascalsTriangleResultCollection.add(1, Arrays.asList(1,1));
        pascalsTriangleResultCollection.add(2, Arrays.asList(1,2,1));
        pascalsTriangleResultCollection.add(3, Arrays.asList(1,3,3,1));
        pascalsTriangleResultCollection.add(4, Arrays.asList(1,4,6,4,1));
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @DisplayName("Test for Pascal's Triangle")
    @CsvSource("5")
    void mySelf_IterationPascalsTriangle(int pascalTriangleRow) {
        Object[] toCalculateResultArray = pascalsTriangle.mySelf_IterationPascalsTriangle(pascalTriangleRow).toArray();
        Object[] expectedResultArray = pascalsTriangleResultCollection.toArray();
        assertArrayEquals(expectedResultArray, toCalculateResultArray);
    }
    @ParameterizedTest
    @DisplayName("Test for Pascal's Triangle")
    @CsvSource("5")
    void econdIterationPascalsTriangle(int pascalTriangleRow) {
        pascalsTriangle.mySelf_SecondIterationPascalsTriangle(pascalTriangleRow);
    }
}