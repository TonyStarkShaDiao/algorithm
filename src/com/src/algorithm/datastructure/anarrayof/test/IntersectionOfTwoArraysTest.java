package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.IntersectionOfTwoArrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionOfTwoArraysTest {
    IntersectionOfTwoArrays intersectionOfTwoArrays;

    @BeforeEach
    void setUp() {
        intersectionOfTwoArrays = new IntersectionOfTwoArrays();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("hash获取两个数组元素的交集(元素可重复)")
    @ParameterizedTest
    @CsvSource("1;2;2;1,2;2")
    void mySelf_HashIntersectionOfTwoArrays(@ConvertWith(StringArrayConverterConfig.class) int[] firstOneArrayParam, @ConvertWith(StringArrayConverterConfig.class) int[] secondArrayParam) {
        int[] arrayIntersectionResult = intersectionOfTwoArrays.mySelf_HashIntersectionOfTwoArrays(firstOneArrayParam, secondArrayParam);
        assertArrayEquals(new int[]{2, 2}, arrayIntersectionResult);
    }

    @DisplayName("排序获取两个数组元素的交集(元素可重复)")
    @ParameterizedTest
    @CsvSource("1;2;2;1,2;2")
    void mySelf_doublePointerIntersectionOfTwoArrays(@ConvertWith(StringArrayConverterConfig.class) int[] firstOneArrayParam, @ConvertWith(StringArrayConverterConfig.class) int[] secondArrayParam) {
        int[] arrayIntersectionResult = intersectionOfTwoArrays.mySelf_doublePointerIntersectionOfTwoArrays(firstOneArrayParam, secondArrayParam);
        assertArrayEquals(new int[]{2, 2}, arrayIntersectionResult);
    }

}