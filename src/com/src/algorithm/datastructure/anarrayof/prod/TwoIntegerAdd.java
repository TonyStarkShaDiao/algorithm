package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两个整数加
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/15
 */
public class TwoIntegerAdd {

    public List<Integer> mySelf_TwoIntegerAdd(int[] firstOneArray, int integerValue) {
        int firstOneArrayIndex = firstOneArray.length - 1;
        int carryValue = 0;
        List<Integer> eachDigitCalculationResults = new ArrayList<>();
        while (firstOneArrayIndex >= 0 || integerValue != 0) {
            int currentFirstOneArrayDigitsElement = firstOneArrayIndex < 0 ? 0 : firstOneArray[firstOneArrayIndex];
            int currentIntegerValueDigitsElement = integerValue == 0 ? 0 : integerValue % 10;
            int currentSum = currentFirstOneArrayDigitsElement + currentIntegerValueDigitsElement + carryValue;
            eachDigitCalculationResults.add(GetTheOnesDigitValue(currentSum));
            carryValue = getCarryValue(currentSum);
            firstOneArrayIndex--;
            integerValue = integerValue / 10;
        }
        if (carryValue != 0) {
            eachDigitCalculationResults.add(carryValue);
        }
        Collections.reverse(eachDigitCalculationResults);

        return eachDigitCalculationResults;
    }

    /**
     * 获得进位数的值
     *
     * @param currentSum 当前总和
     * @return int
     */
    private int getCarryValue(int currentSum) {
        return currentSum / 10;
    }

    /**
     * 获取个位数的值
     *
     * @param currentSum 当前总和
     * @return int
     */
    private int GetTheOnesDigitValue(int currentSum) {
        return currentSum % 10;
    }

    public List<Integer> mySelf_TwoIntegerArrayAdd(int[] firstOneArray, int[] secondOneArray) {
        int firstOneArrayIndex = firstOneArray.length - 1;
        int secondOneArrayIndex = secondOneArray.length - 1;
        List<Integer> eachDigitCalculationResults = new ArrayList<>();
        int carryValue = 0;
        while (firstOneArrayIndex >= 0 || secondOneArrayIndex >= 0) {
            int currentFirstOneArrayDigitsElement = firstOneArrayIndex < 0 ? 0 : firstOneArray[firstOneArrayIndex];
            int currentSecondOneArrayDigitsElement = secondOneArrayIndex < 0 ? 0 : secondOneArray[secondOneArrayIndex];
            int currentSum = currentFirstOneArrayDigitsElement + currentSecondOneArrayDigitsElement + carryValue;
            eachDigitCalculationResults.add(GetTheOnesDigitValue(currentSum));
            carryValue = getCarryValue(currentSum);
            secondOneArrayIndex--;
            firstOneArrayIndex--;
        }
        if (carryValue > 0) {
            eachDigitCalculationResults.add(carryValue);
        }
        Collections.reverse(eachDigitCalculationResults);
        return eachDigitCalculationResults;
    }

}
