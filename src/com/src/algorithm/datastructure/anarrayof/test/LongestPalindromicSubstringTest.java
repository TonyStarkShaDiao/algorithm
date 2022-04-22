package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.LongestPalindromicSubstring;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring longestPalindromicSubstring;
    private String needAnalysisCharacterString;

    private String expectedValue;
    @BeforeEach
    void setUp() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
        needAnalysisCharacterString = "aaccbb";
        expectedValue = "aa";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_centralDiffusionLongestPalindromicSubstring() {
        String needChecklongestPalindromicSubstring = longestPalindromicSubstring.mySelf_centralDiffusionLongestPalindromicSubstring(needAnalysisCharacterString);
        assertEquals(expectedValue, needChecklongestPalindromicSubstring);
    }

    @Test
    void mySelf_SecondCentralDiffusionLongestPalindromicSubstring() {
        String needChecklongestPalindromicSubstring = longestPalindromicSubstring.mySelf_centralDiffusionLongestPalindromicSubstring(needAnalysisCharacterString);
        assertEquals(expectedValue, needChecklongestPalindromicSubstring);
    }
}