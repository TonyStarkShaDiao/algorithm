package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ProgressiveIncreaseTernarySubSequence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgressiveIncreaseTernarySubSequenceTest {
    public static final String THE_TERNARY_SUB_SEQUENCE_IS_NOT_EXIST = "The Ternary Sub Sequence is not exist";
    private ProgressiveIncreaseTernarySubSequence progressiveIncreaseTernarySubSequence;
    int[] existStayCheckTernarySubSequenceArray;
    int[] notExistStayCheckTernarySubSequenceArray;

    @BeforeEach
    void setUp() {
        progressiveIncreaseTernarySubSequence = new ProgressiveIncreaseTernarySubSequence();
        existStayCheckTernarySubSequenceArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        notExistStayCheckTernarySubSequenceArray = new int[]{-3, -5, -6, 3, -5};
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("mySelf_CheckIsExistTernarySubSequenceIsExist")
    @Test
    void mySelf_CheckIsExistTernarySubSequenceIsExist() {
        Boolean checkIsExistTernarySubSequence = progressiveIncreaseTernarySubSequence.mySelf_CheckIsExistTernarySubSequence(existStayCheckTernarySubSequenceArray);
        assertTrue(checkIsExistTernarySubSequence, THE_TERNARY_SUB_SEQUENCE_IS_NOT_EXIST);
    }

    @DisplayName("mySelf_CheckIsExistTernarySubSequenceIsNotExist")
    @Test
    void mySelf_CheckIsExistTernarySubSequenceIsNotExist() {
        Boolean checkIsExistTernarySubSequence = progressiveIncreaseTernarySubSequence.mySelf_CheckIsExistTernarySubSequence(notExistStayCheckTernarySubSequenceArray);
        assertFalse(checkIsExistTernarySubSequence, THE_TERNARY_SUB_SEQUENCE_IS_NOT_EXIST);
    }
}