package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.TwoOrderlyArrayMerge;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TwoOrderlyArrayMergeTest {
    TwoOrderlyArrayMerge twoOrderlyArrayMerge;
    @BeforeEach
    void setUp() {
        twoOrderlyArrayMerge=  new TwoOrderlyArrayMerge();
    }

    @AfterEach
    void tearDown() {
    }

    @CsvSource("1;2;3;0;0;0;0,3,2;3;4;5,4")
    @ParameterizedTest
    @DisplayName("合并两个有序数组")
    void mySelf_DoublePointer(@ConvertWith(StringArrayConverterConfig.class) int[] firstOneArrays, int firstOneArraysLength, @ConvertWith(StringArrayConverterConfig.class)int[] secondArrays, int secondArraysLength ) {

        int[] mergeResult = twoOrderlyArrayMerge.mySelf_DoublePointer(firstOneArrays, firstOneArraysLength, secondArrays, secondArraysLength);

        assertArrayEquals(new int[]{1,2,2,3,3,4,5},mergeResult);
    }
    @CsvSource("1;2;3;0;0;0;0,3,2;3;4;5,4")
    @ParameterizedTest
    @DisplayName("合并两个有序数组")
    void mySelf_ReverseDoublePointer(@ConvertWith(StringArrayConverterConfig.class) int[] firstOneArrays, int firstOneArraysLength, @ConvertWith(StringArrayConverterConfig.class)int[] secondArrays, int secondArraysLength ) {

        int[] mergeResult = twoOrderlyArrayMerge.mySelf_ReverseDoublePointer(firstOneArrays, firstOneArraysLength, secondArrays, secondArraysLength);

        assertArrayEquals(new int[]{1,2,2,3,3,4,5},mergeResult);
    }
    @CsvSource("0,0,2,1")
    @ParameterizedTest
    @DisplayName("合并两个有序数组")
    void mySelf_ReverseDoublePointerForFirstOneArraysEmpty(@ConvertWith(StringArrayConverterConfig.class) int[] firstOneArrays, int firstOneArraysLength, @ConvertWith(StringArrayConverterConfig.class)int[] secondArrays, int secondArraysLength ) {

        int[] mergeResult = twoOrderlyArrayMerge.mySelf_ReverseDoublePointer(firstOneArrays, firstOneArraysLength, secondArrays, secondArraysLength);

        assertArrayEquals(new int[]{2},mergeResult);
    }

}
