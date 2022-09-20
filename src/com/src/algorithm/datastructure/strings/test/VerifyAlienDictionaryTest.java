package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.VerifyAlienDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VerifyAlienDictionaryTest {

    private String[] wordArray;
    private String alphabet;

    private VerifyAlienDictionary verifyAlienDictionaryUnderTest;

    @BeforeEach
    void setUp() {
        verifyAlienDictionaryUnderTest = new VerifyAlienDictionary();
        wordArray = new String[]{"apple", "app"};
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }


    @Test
    void testIsAlienSorted() {
        assertThat(verifyAlienDictionaryUnderTest.isAlienSorted(wordArray, alphabet)).isFalse();
    }
}
