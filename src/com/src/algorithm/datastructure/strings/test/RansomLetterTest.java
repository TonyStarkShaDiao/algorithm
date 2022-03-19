package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.RansomLetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import sun.java2d.pipe.SpanIterator;

import static org.junit.jupiter.api.Assertions.*;

class RansomLetterTest {
  RansomLetter ransomLetter;
    @BeforeEach
    void setUp() {
    ransomLetter =new RansomLetter();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("查找字符串中第一个不重复的字符hash解法")
    @ParameterizedTest
    @CsvSource("bg,efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj")
    void mySelf_CharterCountStatistical(String needJudgeString,String toCompareString) {
        ransomLetter.mySelf_CharterCountStatistical(needJudgeString,toCompareString);
    }
}