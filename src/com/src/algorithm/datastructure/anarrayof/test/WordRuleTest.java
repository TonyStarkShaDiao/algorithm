package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.WordRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordRuleTest {
    WordRule wordRule;
    /**
     * 规则
     */
    String pattern;
    /**
     * 单词
     */
    String word;

    @BeforeEach
    void setUp() {
        wordRule = new WordRule();
        word = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_wordsAndRulesWhetherMatching() {
        Boolean matchingResults = wordRule.mySelf_wordsAndRulesWhetherMatching(word, pattern);
        assertTrue(matchingResults);
    }
}