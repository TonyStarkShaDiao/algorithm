package com.src.algorithm.datastructure.queue.test;

import com.src.algorithm.datastructure.queue.prod.SortByCharacterFrequency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

class SortByCharacterFrequencyTest {

    private SortByCharacterFrequency sortByCharacterFrequencyUnderTest;
    private String needSortString;
    private String firstKindExpectValue;
    private String secondKindExpectValue;

    @BeforeEach
    void setUp() {
        sortByCharacterFrequencyUnderTest = new SortByCharacterFrequency();
        needSortString = "tree";
        firstKindExpectValue = "eert";
        secondKindExpectValue = "eetr";

    }

    @Test
    void testMyself_bucketSortByCharacterFrequency() {
        assertThat(sortByCharacterFrequencyUnderTest.Myself_bucketSortByCharacterFrequency(needSortString)).isEqualTo((firstKindExpectValue));


    }

    @Test
    void testMyself_MaxHeapSortByCharacterFrequency() {
        assertThat(sortByCharacterFrequencyUnderTest.Myself_MaxHeapSortByCharacterFrequency(
                needSortString)).isEqualTo(secondKindExpectValue);
    }
}
