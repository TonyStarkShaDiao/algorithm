package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.PalindromeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeNumberTest {

    private PalindromeNumber palindromeNumberUnderTest;

    @BeforeEach
    void setUp() {
        palindromeNumberUnderTest = new PalindromeNumber();
    }

    @Test
    void testMySelf_tailInsertionPalindromeNumber() {
        assertThat(palindromeNumberUnderTest.mySelf_tailInsertionPalindromeNumber(0)).isTrue();
    }
}
