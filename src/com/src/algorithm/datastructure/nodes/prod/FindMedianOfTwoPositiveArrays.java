package com.src.algorithm.datastructure.nodes.prod;

/**
 * 求两个正数组中值
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/29
 */
public class FindMedianOfTwoPositiveArrays {
    public double mergeArrayFindMedianOfTwoPositiveArrays(int firstOneArray[], int secondOneArray[]) {
        int[] mergeArray = new int[firstOneArray.length + secondOneArray.length];
        mergeArray = this.mergeArray(mergeArray, firstOneArray, secondOneArray);
        int mergeArrayLength = mergeArray.length;
        if (mergeArrayLength % 2 == 0) {
            return (mergeArray[mergeArrayLength / 2] + mergeArray[mergeArrayLength / 2 - 1]) / 2.0;
        } else {
            return mergeArray[mergeArrayLength / 2];
        }
    }

    private int[] mergeArray(int[] mergeArray, int[] firstOneArray, int[] secondOneArray) {
        int firstOneArrayIndex = 0;
        int secondOneArrayIndex = 0;
        int mergeArrayIndex = 0;
        while (firstOneArrayIndex < firstOneArray.length && secondOneArrayIndex < secondOneArray.length) {
            if (firstOneArray[firstOneArrayIndex] <= secondOneArray[secondOneArrayIndex]) {
                mergeArray[mergeArrayIndex] = firstOneArray[firstOneArrayIndex];
                firstOneArrayIndex++;
            } else {
                mergeArray[mergeArrayIndex] = secondOneArray[secondOneArrayIndex];
                secondOneArrayIndex++;
            }
            mergeArrayIndex++;
        }
        while (firstOneArrayIndex < firstOneArray.length) {
            mergeArray[mergeArrayIndex] = firstOneArray[firstOneArrayIndex];
            firstOneArrayIndex++;
            mergeArrayIndex++;
        }
        while (secondOneArrayIndex < secondOneArray.length) {
            mergeArray[mergeArrayIndex] = secondOneArray[secondOneArrayIndex];
            secondOneArrayIndex++;
            mergeArrayIndex++;
        }
        return mergeArray;
    }
}
