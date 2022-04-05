package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ThreeNumberSum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeNumberSumTest {

    ThreeNumberSum threeNumberSum;
    @BeforeEach
    void setUp() {
        threeNumberSum =new ThreeNumberSum();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @DisplayName("暴力枚举")
    @CsvSource("'-1,0,1,2,-1,-4'")
    void myself_TripleTraversalThreeNumberSum(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray ) {
        List<List<Integer>> lists = threeNumberSum.Myself_TripleTraversalThreeNumberSum(specifiedFindArray);
        System.out.println(lists);
    }
    @ParameterizedTest
    @DisplayName("排序")
    @CsvSource("'-1,0,1,2,-1,-4'")
    void myself_OrderTripleTraversalThreeNumberSum(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        List<List<Integer>> lists = threeNumberSum.Myself_OrderTripleTraversalThreeNumberSum(specifiedFindArray);
        System.out.println(lists);
    }

    @ParameterizedTest
    @DisplayName("双指针")
    @CsvSource("'3,0,-2,-1,1,2'")
    void myself_DoublePointerThreeNumberSum(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        List<List<Integer>> lists = threeNumberSum.Myself_DoublePointerThreeNumberSum(specifiedFindArray);
//        3 -2 -1 ,0-1 1 ,0-2 2,-2-1-1
        System.out.println(lists);
    }

//    @ParameterizedTest
//    @DisplayName("正确答案")
//    @CsvSource("'-1,0,1,2,-1,-4'")
//    void threeSum(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
//        List<List<Integer>> lists = threeNumberSum.threeSum(specifiedFindArray);
//        System.out.println(lists);
//    }
}