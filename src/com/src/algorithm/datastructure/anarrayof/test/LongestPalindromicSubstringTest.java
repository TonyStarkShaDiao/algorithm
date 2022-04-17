package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.LongestPalindromicSubstring;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring longestPalindromicSubstring;
    private String needFindCharacterString;
    private int expectMaximumPalindromeSubstringCount;

    @BeforeEach
    void setUp() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
        needFindCharacterString = "abcdcba";
        expectMaximumPalindromeSubstringCount = 7;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_LongestPalindromicSubstring() {
        int result = longestPalindromicSubstring.myself_LongestPalindromicSubstring(needFindCharacterString);
        assertEquals(expectMaximumPalindromeSubstringCount, result);
    }
}