package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.StringConvertInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringConvertIntegerTest {

    private StringConvertInteger stringConvertIntegerUnderTest;

    @BeforeEach
    void setUp() {
        stringConvertIntegerUnderTest = new StringConvertInteger();
    }

    @Test
    void testMySelf_StringConvertInteger() {
        assertThat(stringConvertIntegerUnderTest.mySelf_StringConvertInteger("2147483648")).isEqualTo(0);
    }
}
