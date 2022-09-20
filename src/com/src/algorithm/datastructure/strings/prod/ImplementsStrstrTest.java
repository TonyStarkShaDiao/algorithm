package com.src.algorithm.datastructure.strings.prod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImplementsStrstrTest {

    private ImplementsStrstr implementsStrstrUnderTest;

    @BeforeEach
    void setUp() {
        implementsStrstrUnderTest = new ImplementsStrstr();
    }

    @Test
    void testMySelf_kmpImplementsStrstr() {
        assertThat(implementsStrstrUnderTest.mySelf_kmpImplementsStrstr("mississippi", "sipp"))
                .isEqualTo(0);
    }
}
