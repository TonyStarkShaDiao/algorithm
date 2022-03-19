package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.WithoutRepetitionFirstCharInString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WithoutRepetitionFirstCharInStringTest {


    private WithoutRepetitionFirstCharInString withoutRepetitionFirstCharInString;
    @BeforeEach
    void setUp() {
        withoutRepetitionFirstCharInString =new WithoutRepetitionFirstCharInString();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("查找字符串中第一个不重复的字符hash解法")
    @ParameterizedTest
    @ValueSource(strings = "leetcode")
    void mySelf_Hash(String NeedToFindStringParam) {
//            assertEquals(NeedToFindStringParam, "", "入参为空");
        int findCharResultIndex = withoutRepetitionFirstCharInString.mySelf_Hash(NeedToFindStringParam);
        assertEquals(0, findCharResultIndex,"查找下标错误");
    }

    @DisplayName("查找字符串中第一个不重复的字符hash解法")
    @ParameterizedTest
    @ValueSource(strings = "leetcode")
    void mySelf_ImprovedHash(String NeedToFindStringParam) {
        int findCharResultIndex = withoutRepetitionFirstCharInString.mySelf_ImprovedHash(NeedToFindStringParam);
        assertEquals(0, findCharResultIndex,"改进hash方法查找下标出错");
    }

    @DisplayName("查找字符串中第一个不重复的字符二元组两次循环解法")
    @ParameterizedTest
    @ValueSource(strings = "leetcode")
    void mySelf_TwoTuples(String NeedToFindStringParam) {
        int findCharResultIndex = withoutRepetitionFirstCharInString.mySelf_TwoTuples(NeedToFindStringParam);
        assertEquals(0, findCharResultIndex,"二元组方法查找下标出错");

    }

    @DisplayName("查找字符串中第一个不重复的字符二元组一次循环解法")
    @ParameterizedTest
    @ValueSource(strings = "leetcode")
    void mySelf_ImprovedTwoTuples(String NeedToFindStringParam) {
        int findCharResultIndex = withoutRepetitionFirstCharInString.mySelf_ImprovedCharacterIndex(NeedToFindStringParam);
        assertEquals(0, findCharResultIndex,"按照顺序查找一个字符在第一次出现的位置和最后一次出现的位置是否相同方法查找下标出错");
    }
}