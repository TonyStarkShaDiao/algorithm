package com.src.algorithm.datastructure.mathematics.test;

import com.src.algorithm.datastructure.mathematics.prod.MatchToSquare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchToSquareTest {

    private MatchToSquare matchToSquareUnderTest;

    @BeforeEach
    void setUp() {
        matchToSquareUnderTest = new MatchToSquare();
    }

    @Test
    void testMakesquare() {
        assertThat(matchToSquareUnderTest.makesquare(new int[]{2, 2, 2, 1, 1})).isFalse();
    }
}
