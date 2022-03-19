package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.TwoNumberSum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumTest {
    TwoNumberSum twoNumberSum;
    @BeforeEach
    void setUp() {
        twoNumberSum =new TwoNumberSum();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * 我自己哈希
     *
     * @param arraysParam 数组参数
     */
    @ParameterizedTest
    @DisplayName("第一次两数之和hash 算法测试")
    @CsvSource("1; 5; 6; 2; 7; 8,10")
//    @ValueSource(ints = 9)
    void mySelf_Hash(@ConvertWith(StringArrayConverterConfig.class)int[] arraysParam, int target) {

        int[] ints = twoNumberSum.mySelf_Hash(arraysParam, target);
        assertArrayEquals(new int[]{3,5},ints);
    }
    @ParameterizedTest
    @CsvSource("abc,123,1;2")
    void test(String column1, int column2, @ConvertWith(StringArrayConverterConfig.class) int[] column3) {
        assertEquals(column1, "abc");
        assertEquals(column2, 123);
        assertEquals(column3[0], "1");
        assertEquals(column3[1], "2");
    }

}