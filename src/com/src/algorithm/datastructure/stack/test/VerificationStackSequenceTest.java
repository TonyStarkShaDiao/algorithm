package com.src.algorithm.datastructure.stack.test;

import com.src.algorithm.datastructure.stack.prod.VerificationStackSequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VerificationStackSequenceTest {

    private VerificationStackSequence verificationStackSequenceUnderTest;
    int[] pushArray = {1, 2, 3, 4, 5};
    int[] popArray = {4, 5, 3, 2, 1};

    @BeforeEach
    void setUp() {
        verificationStackSequenceUnderTest = new VerificationStackSequence();
    }

    @Test
    void testMySelf_VerificationStackSequence() {
        assertThat(verificationStackSequenceUnderTest.mySelf_VerificationStackSequence(pushArray, popArray)).isTrue();
        ;
    }

}
