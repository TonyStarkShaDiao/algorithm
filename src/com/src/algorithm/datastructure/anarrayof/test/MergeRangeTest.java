package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.MergeRange;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MergeRangeTest {
    public static final String ERROR_MESSAGE = "结果不为为三个合并数组,算法错误";
    int [][] needMergeIntervalArray;
    int [][] expectMergeIntervalArrayResult;
    MergeRange mergeRange;
    @BeforeEach
    void setUp() {
        mergeRange =new MergeRange();
//        [[1,3],[2,6],[8,10],[15,18]]
        needMergeIntervalArray =new int[4][];
        needMergeIntervalArray[0]=new int[]{1,3};
        needMergeIntervalArray[1]=new int[]{2,6};
        needMergeIntervalArray[2]=new int[]{8,10};
        needMergeIntervalArray[3]=new int[]{15,18};
//        [[1,6],[8,10],[15,18]]
        expectMergeIntervalArrayResult =new int[3][];
        expectMergeIntervalArrayResult[0]=new int[]{1,6};
        expectMergeIntervalArrayResult[1]=new int[]{8,10};
        expectMergeIntervalArrayResult[2]=new int[]{15,18};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_forFirstTime_merge() {
        int[][] mergeIntervalResult = mergeRange.myself_forFirstTime_merge(needMergeIntervalArray);
        Assertions.assertArrayEquals(mergeIntervalResult,expectMergeIntervalArrayResult, ERROR_MESSAGE);
    }

    @Test
    void myself_secondTime_merge() {
        int[][] mergeIntervalResult = mergeRange.myself_secondTime_merge(needMergeIntervalArray);
        System.out.println(Arrays.toString(mergeIntervalResult));
        Assertions.assertArrayEquals(mergeIntervalResult,expectMergeIntervalArrayResult, ERROR_MESSAGE);
    }
}