package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.EctopicEffectiveLetterWord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EctopicEffectiveLetterWordTest {

    EctopicEffectiveLetterWord ectopicEffectiveLetterWord;
    @BeforeEach
    void setUp() {
        ectopicEffectiveLetterWord =new EctopicEffectiveLetterWord();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("查找字符串中第一个不重复的字符hash解法")
    @ParameterizedTest
    @CsvSource("anagram,nagaram")
    void mySelf_HashCount(String firstOneToCompareString, String secondToCompareString) {
        Boolean aBoolean = ectopicEffectiveLetterWord.mySelf_HashCount(firstOneToCompareString, secondToCompareString);
assertTrue(aBoolean,"验证失败,应当结果重复");
    }    @DisplayName("查找字符串中第一个不重复的字符hash解法")
    @ParameterizedTest
    @CsvSource("aacc,ccac")
    void mySelf_HashCountErrorResult(String firstOneToCompareString, String secondToCompareString) {
        Boolean aBoolean = ectopicEffectiveLetterWord.mySelf_HashCount(firstOneToCompareString, secondToCompareString);
assertFalse(aBoolean,"验证失败,应当结果重复");
    }
}