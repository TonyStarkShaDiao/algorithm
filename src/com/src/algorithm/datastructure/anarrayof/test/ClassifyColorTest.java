package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ClassifyColor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class ClassifyColorTest {
    public static final String THREE_POINT_CLASS_IFY_MESSAGE = "三指针颜色分类不正确";
    ClassifyColor classifyColor;
    @BeforeEach
    void setUp() {
        classifyColor =new ClassifyColor();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @DisplayName("三指针边界交换算法/正确性验证测试")
    @CsvSource("'2,0,2,1,1,0'")
    void mySelf_ThreePointToSwapClassifyColor(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] needToBeClassifiedArray) {
        classifyColor.mySelf_ThreePointToSwapClassifyColor(needToBeClassifiedArray);
        Assertions.assertArrayEquals(needToBeClassifiedArray, new int[]{0,0,1,1,2,2}, THREE_POINT_CLASS_IFY_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("三指针赋值算法正确性验证测试")
    @CsvSource("'2,0,2,1,1,0'")
    void mySelf_OnceTraverseClassifyColor(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] needToBeClassifiedArray) {
        classifyColor.mySelf_ThreePointToSwapClassifyColor(needToBeClassifiedArray);
        Assertions.assertArrayEquals(needToBeClassifiedArray, new int[]{0,0,1,1,2,2}, THREE_POINT_CLASS_IFY_MESSAGE);
    }

}