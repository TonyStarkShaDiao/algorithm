package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.RepetitiveDNASequence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepetitiveDNASequenceTest {
    private RepetitiveDNASequence repetitiveDNASequence;
    private String needAnalysisCharacterString;
    private List<String> expectedResultsCollect;

    @BeforeEach
    void setUp() {
        repetitiveDNASequence = new RepetitiveDNASequence();
        needAnalysisCharacterString = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        expectedResultsCollect = new ArrayList<String>() {{
            add("AAAAACCCCC");
            add("CCCCCAAAAA");
        }};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("HashSlidingWindow")
    void mySelf_HashSlidingWindowRepetitiveDNASequence() {
        List<String> repeatingSubstringCollect = repetitiveDNASequence.mySelf_HashSlidingWindowRepetitiveDNASequence(needAnalysisCharacterString);
        assertArrayEquals(expectedResultsCollect.toArray(), repeatingSubstringCollect.toArray());
    }

    @Test
    @DisplayName("hash")
    void myself_HashRepetitiveDNASequence() {
        List<String> repeatingSubstringCollect = repetitiveDNASequence.myself_HashRepetitiveDNASequence(needAnalysisCharacterString);
        assertArrayEquals(expectedResultsCollect.toArray(), repeatingSubstringCollect.toArray());
    }
}