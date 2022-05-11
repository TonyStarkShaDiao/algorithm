package com.src.algorithm.datastructure.graph.test;

import com.src.algorithm.datastructure.graph.prod.FindTheTownJudge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheTownJudgeTest {

    private FindTheTownJudge findTheTownJudgeUnderTest;
    private int[][] personVoteIntentionArray;
    private int[] expectVoteIntentionArray;

    @BeforeEach
    void setUp() {
        findTheTownJudgeUnderTest = new FindTheTownJudge();
        personVoteIntentionArray = new int[4][];
        int[] jackVoteIntention = new int[]{1, 2};
        int[] jillVoteIntention = new int[]{3, 2};
        int[] jamesVoteIntention = new int[]{4, 2};
        int[] janeVoteIntention = new int[]{5, 2};
        personVoteIntentionArray[0] = jackVoteIntention;
        personVoteIntentionArray[1] = jillVoteIntention;
        personVoteIntentionArray[2] = jamesVoteIntention;
        personVoteIntentionArray[3] = janeVoteIntention;
        expectVoteIntentionArray = new int[]{2, -1};
    }

    @Test
    void testMySelf_FindTheTownJudge() {
        final int result = findTheTownJudgeUnderTest.mySelf_FindTheTownJudge(personVoteIntentionArray.length + 1, personVoteIntentionArray);
        assertThat(result).isEqualTo(expectVoteIntentionArray[0]);
    }
}
