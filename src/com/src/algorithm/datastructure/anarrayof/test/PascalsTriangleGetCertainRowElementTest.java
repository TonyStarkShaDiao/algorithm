package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.PascalsTriangleGetCertainRowElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleGetCertainRowElementTest {

    PascalsTriangleGetCertainRowElement pascalsTriangleGetCertainRowElement;
    Object [] expectedArray;
    @BeforeEach
    void setUp() {
        pascalsTriangleGetCertainRowElement =new PascalsTriangleGetCertainRowElement();
        expectedArray =new Object[]{1,3,3,1,};
    }

    @AfterEach
    void tearDown() {

    }

    @ParameterizedTest
    @DisplayName("Test for Pascal's Triangle")
    @CsvSource("3")
    void myself_pascalsTriangleGetCertainRowElement(int  pascalsTriangleRowIndex) {
        Object[] pascalsTriangleRowElementResult = pascalsTriangleGetCertainRowElement.Myself_pascalsTriangleGetCertainRowElement(pascalsTriangleRowIndex).toArray();
        assertArrayEquals(pascalsTriangleRowElementResult,expectedArray);
    }

    @ParameterizedTest
    @DisplayName("Test for Pascal's Triangle")
    @CsvSource("3")
    void myself_ReversePascalsTriangleGetCertainRowElement(int  pascalsTriangleRowIndex) {
        Object[] pascalsTriangleRowElementResult = pascalsTriangleGetCertainRowElement.Myself_ReversePascalsTriangleGetCertainRowElement(pascalsTriangleRowIndex).toArray();
        assertArrayEquals(pascalsTriangleRowElementResult,expectedArray);
    }
}