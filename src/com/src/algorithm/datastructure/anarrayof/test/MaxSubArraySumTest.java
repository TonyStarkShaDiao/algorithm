package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.MaxSubArraySum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArraySumTest {
    MaxSubArraySum maxSubArraySum;
    @BeforeEach
    void setUp() {
        maxSubArraySum =new MaxSubArraySum();
    }

    @AfterEach
    void tearDown() {
    }

    @CsvSource("'-2,1,-3,4,-1,2,1,-5,4'")
    @ParameterizedTest
    @DisplayName("最大子序和动态规划解法正确测试")
    void mySelf_dynamicProgrammingNumberTest(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] manyParamArrays) {

        assertEquals(maxSubArraySum.mySelf_dynamicProgramming(manyParamArrays), 6,"期望结果为6" );
    }

    @CsvSource("'-2,-1,-3,-4,-1,-2,-1,-5,-4'")
    @ParameterizedTest
    @DisplayName("最大子序和动态规划算法负数测试")
    void mySelf_dynamicProgrammingAllNegativeNumberTest(@ConvertWith(WritingRemoveDuplicatesTest.class)int[] manyParamArrays) {
    assertEquals(maxSubArraySum.mySelf_dynamicProgramming(manyParamArrays),-1, "期望结果为6");
    }

    /**
     * 我自己贪婪算法正数测试
     * 我自己贪婪算法全部正数测试
     *
     * @param manyParamArrays 许多参数数组
     */
    @CsvSource("'1,2'")
@ParameterizedTest
@DisplayName("最大子序和贪心算法解法正数测试")
void mySelf_greedyAlgorithmAllPositiveNumberTest(@ConvertWith(WritingRemoveDuplicatesTest.class)int[] manyParamArrays) {
    assertEquals(maxSubArraySum.mySelf_greedyAlgorithm(manyParamArrays),3, "期望结果为6");
}

    /**
     * 所有负数测试自己贪婪算法

     *
     * @param manyParamArrays 许多参数数组
     */
    @CsvSource("'-2,-1,-3,-4,-1,-2,-1,-5,-4'")
    @ParameterizedTest
    @DisplayName("最大子序和贪心算法解法负数测试")
    void mySelf_greedyAlgorithmAllNegativeNumberTest(@ConvertWith(WritingRemoveDuplicatesTest.class)int[] manyParamArrays) {
        assertEquals(maxSubArraySum.mySelf_greedyAlgorithm(manyParamArrays),-1, "期望结果为6");
    }
}