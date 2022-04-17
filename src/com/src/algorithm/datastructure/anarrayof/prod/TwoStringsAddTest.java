package com.src.algorithm.datastructure.anarrayof.prod;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStringsAddTest {
    private TwoStringsAdd twoStringsAdd;
    String firstOneString;
    String secondOneString;
    String expectAddStringResult;

    @BeforeEach
    void setUp() {
        twoStringsAdd = new TwoStringsAdd();
        firstOneString = "1024";
        secondOneString = "1024";
        expectAddStringResult = "2048";

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_TwoStringAdd() {
        String addStringResult = twoStringsAdd.mySelf_TwoStringAdd(firstOneString, secondOneString);
        assertEquals(expectAddStringResult, addStringResult);
    }
}