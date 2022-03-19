package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ContainsDuplicate;
import com.src.algorithm.datastructure.anarrayof.prod.MostOfElements;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 多数元素测试
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/19
 */
class MostOfElementsTest {

    MostOfElements mostOfElements;
    private int expectedToMoreThanHalfNumberOfValues;

    @BeforeEach
    void setUp() {
        expectedToMoreThanHalfNumberOfValues=3;
        mostOfElements =new MostOfElements();
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试成功");
    }

    @CsvSource("'3,2,3'")
    @ParameterizedTest
    @DisplayName("最大子序和动态规划算法负数测试")
    void mySelf_SortLookingForMoreThanHalfElementInArray(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        int moreThanHalfOfNumberInArray = mostOfElements.mySelf_SortLookingForMoreThanHalfElementInArray(specifiedFindArray);
        Assertions.assertEquals(moreThanHalfOfNumberInArray, expectedToMoreThanHalfNumberOfValues);
    }

    @CsvSource("'3,2,3'")
    @ParameterizedTest
    @DisplayName("最大子序和动态规划算法负数测试")
    void mySelf_HashLookingForMoreThanHalfElementInArray(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        int moreThanHalfOfNumberInArray = mostOfElements.mySelf_HashLookingForMoreThanHalfElementInArray(specifiedFindArray);
        Assertions.assertEquals(moreThanHalfOfNumberInArray, expectedToMoreThanHalfNumberOfValues);
    }

    @CsvSource("'3,2,3'")
    @ParameterizedTest
    @DisplayName("最大子序和动态规划算法负数测试")
    void mySelf_MooreVoteLookingForMoreThanHalfElementInArray(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        int moreThanHalfOfNumberInArray = mostOfElements.mySelf_MooreVoteLookingForMoreThanHalfElementInArray(specifiedFindArray);
        Assertions.assertEquals(moreThanHalfOfNumberInArray, expectedToMoreThanHalfNumberOfValues);
    }
}