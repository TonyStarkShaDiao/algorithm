package com.src.algorithm.datastructure.anarrayof.prod;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 除了自己的乘积
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/13
 */
public class ExceptOneSelfProduct {
    public int[] mySelf_toCalculateExceptOneSelfProductInArray(int[] specifiedArray) {
        int[] resultArray = new int[specifiedArray.length];
        resultArray[0] = 1;
        for (int specifiedArrayIndex = 1; specifiedArrayIndex < specifiedArray.length; specifiedArrayIndex++) {
            resultArray[specifiedArrayIndex] = specifiedArray[specifiedArrayIndex - 1] * resultArray[specifiedArrayIndex - 1];
        }
        int rightBoundPreviousAValue = 1;
        for (int specifiedArrayIndex = specifiedArray.length - 1; specifiedArrayIndex >= 0; specifiedArrayIndex--) {
            resultArray[specifiedArrayIndex] = rightBoundPreviousAValue * resultArray[specifiedArrayIndex];
            rightBoundPreviousAValue = specifiedArray[specifiedArrayIndex] * rightBoundPreviousAValue;
        }
        return resultArray;
    }

    public int[] mySelf_secondToCalculateExceptOneSelfProductInArray(int[] specifiedArray) {
        int[] productResultArray = new int[specifiedArray.length];
        productResultArray[0] = 1;
        for (int specifiedArrayElementIndex = 1; specifiedArrayElementIndex < specifiedArray.length; specifiedArrayElementIndex++) {
            productResultArray[specifiedArrayElementIndex] = productResultArray[specifiedArrayElementIndex - 1] * specifiedArray[specifiedArrayElementIndex - 1];
        }
        int currentRightBoundPreviousValue = 1;
        for (int specifiedArrayElementIndex = specifiedArray.length - 1; specifiedArrayElementIndex >= 0; specifiedArrayElementIndex--) {
            productResultArray[specifiedArrayElementIndex] = currentRightBoundPreviousValue * productResultArray[specifiedArrayElementIndex];
            currentRightBoundPreviousValue = specifiedArray[specifiedArrayElementIndex] * currentRightBoundPreviousValue;
        }
        return productResultArray;
    }
}
