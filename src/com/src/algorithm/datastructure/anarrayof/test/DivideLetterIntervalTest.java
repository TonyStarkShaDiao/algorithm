package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.DivideLetterInterval;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivideLetterIntervalTest {

    private DivideLetterInterval divideLetterInterval;
    String needAnalyticIntervalCharacterString;
    Object[] expectCharacterSectionArray;

    @BeforeEach
    void setUp() {
        divideLetterInterval = new DivideLetterInterval();
        needAnalyticIntervalCharacterString = "ababcbacadefegdehijhklij";
        expectCharacterSectionArray = new Object[]{9, 7, 8};
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_SecondDivideLetterInterval() {
        List<Integer> needCheckCharacterSectionCollect = divideLetterInterval.mySelf_secondDivideLetterInterval(needAnalyticIntervalCharacterString);
        assertArrayEquals(expectCharacterSectionArray, needCheckCharacterSectionCollect.toArray());
    }
}