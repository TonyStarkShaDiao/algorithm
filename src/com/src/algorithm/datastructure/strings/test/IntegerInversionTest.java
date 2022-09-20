package com.src.algorithm.datastructure.strings.test;

import com.src.algorithm.datastructure.strings.prod.IntegerInversion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerInversionTest {

    private IntegerInversion integerInversionUnderTest;

    @BeforeEach
    void setUp() {
        integerInversionUnderTest = new IntegerInversion();
    }

    @Test
    void testMySelf_IntegerInversion() {
        assertThat(integerInversionUnderTest.mySelf_IntegerInversion(123)).isEqualTo(0);
    }
}
