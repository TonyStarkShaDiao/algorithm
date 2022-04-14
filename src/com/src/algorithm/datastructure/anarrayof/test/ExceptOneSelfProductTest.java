package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.ExceptOneSelfProduct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptOneSelfProductTest {
    private ExceptOneSelfProduct exceptOneSelfProduct;
    int[] needToCalculateArray;
    int[] exceptOneSelfProductArray;

    @BeforeEach
    void setUp() {
        exceptOneSelfProduct = new ExceptOneSelfProduct();
        needToCalculateArray = new int[]{1, 2, 3, 4};
        exceptOneSelfProductArray = new int[]{24, 12, 8, 6};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_toCalculateExceptOneSelfProductInArray() {
        assertArrayEquals(exceptOneSelfProductArray, exceptOneSelfProduct.mySelf_toCalculateExceptOneSelfProductInArray(needToCalculateArray));
    }

    @Test
    void mySelf_secondToCalculateExceptOneSelfProductInArray() {
        assertArrayEquals(exceptOneSelfProductArray, exceptOneSelfProduct.mySelf_secondToCalculateExceptOneSelfProductInArray(needToCalculateArray));
    }
}