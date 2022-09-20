package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.UniqueSubstringInSurroundString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueSubstringInSurroundStringTest {

    private UniqueSubstringInSurroundString uniqueSubstringInSurroundStringUnderTest;

    @BeforeEach
    void setUp() {
        uniqueSubstringInSurroundStringUnderTest = new UniqueSubstringInSurroundString();
    }

    @Test
    void testMySelf_HashUniqueSubstringInSurroundString() {
        assertThat(uniqueSubstringInSurroundStringUnderTest.mySelf_HashUniqueSubstringInSurroundString(
                "zac")).isEqualTo(0);
    }
}
