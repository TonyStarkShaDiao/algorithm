package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.StringMultiplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMultiplicationTest {

    private StringMultiplication stringMultiplication;
    private String firstString;
    private String secondString;
    private String expectedResult;

    @BeforeEach
    void setUp() {
        stringMultiplication = new StringMultiplication();/**/
        firstString = "123";
        secondString = "1234";
        expectedResult = "151782";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_StringMultiplication() {
        assertEquals(expectedResult, stringMultiplication.mySelf_StringMultiplication(firstString, secondString));
    }

    @Test
    void mySelf_SecondStringMultiplication() {
        assertEquals(expectedResult, stringMultiplication.mySelf_SecondStringMultiplication(firstString, secondString));
    }
}