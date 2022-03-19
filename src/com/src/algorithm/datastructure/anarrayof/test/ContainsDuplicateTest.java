package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ContainsDuplicate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {
    ContainsDuplicate containsDuplicate;
    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
        containsDuplicate =new ContainsDuplicate();
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试成功");
    }

    @ParameterizedTest
    @DisplayName("hashMap正确性验证测试")
    @CsvSource("'1,2,3,1'")
    void mySelf_UsedHashMapHaveRepeatTest(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] arrayParam) {


        assertTrue(containsDuplicate.mySelf_UsedHashMap(arrayParam));
    }
    @ParameterizedTest
    @DisplayName("hashMap正确性验证测试")
    @CsvSource("'1,2,3,4'")
    void mySelf_UsedHashMapDontHaveRepeatTest(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] arrayParam) {


        assertFalse(containsDuplicate.mySelf_UsedHashMap(arrayParam));
    }
    @ParameterizedTest
    @DisplayName("hashSet正确性验证测试")
    @CsvSource("'1,2,3,4'")
    void mySelf_UsedHashSetDontHaveRepeatTest(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] arrayParam) {

        assertFalse(containsDuplicate.mySelf_UsedHashSet(arrayParam));
    }
}