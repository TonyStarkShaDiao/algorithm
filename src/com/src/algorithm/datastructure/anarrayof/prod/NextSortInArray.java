package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;

/**
 * 数组中下一个排序
 * <p>
 * sort
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/12
 * SubscriptTobeExchanged
 */
public class NextSortInArray {
    public void nextSort(int[] needSortArray) {
        for (int currentLastElementIndex = needSortArray.length - 1; currentLastElementIndex >= 0; currentLastElementIndex--) {
            for (int currentElementIndex = needSortArray.length - 1; currentElementIndex > currentLastElementIndex; currentElementIndex--) {
                if (needSortArray[currentLastElementIndex] < needSortArray[currentElementIndex]) {
                    this.arraySwapPosition(needSortArray, currentLastElementIndex, currentElementIndex);
                    Arrays.sort(needSortArray, currentLastElementIndex + 1, needSortArray.length);
                    return;
                }
            }
        }
        Arrays.sort(needSortArray);
    }

    private void arraySwapPosition(int[] needSortArray, int currentLastElementIndex, int currentElementIndex) {
        int temp = needSortArray[currentLastElementIndex];
        needSortArray[currentLastElementIndex] = needSortArray[currentElementIndex];
        needSortArray[currentElementIndex] = temp;
    }

    public void mySelf_nextSort(int[] needSortArray) {
        int needSortArrayLength = needSortArray.length;
        int beNeedSwapIndex = needSortArrayLength - 2;
        while (beNeedSwapIndex >= 0 && needSortArray[beNeedSwapIndex] >= needSortArray[beNeedSwapIndex + 1]) {
            beNeedSwapIndex--;
        }
        if (beNeedSwapIndex < 0) {
            this.reversal(needSortArray, 0, needSortArrayLength - 1);
        } else {
            int needSwapIndex = needSortArrayLength - 1;
            while (needSwapIndex > beNeedSwapIndex && needSortArray[needSwapIndex] <= needSortArray[beNeedSwapIndex]) {
                needSwapIndex--;
            }
            this.swapArrayIndex(needSortArray, beNeedSwapIndex, needSwapIndex);
            this.reversal(needSortArray, beNeedSwapIndex + 1, needSortArrayLength - 1);
        }
    }

    private void reversal(int[] needSortArray, int headerPoint, int tailPoint) {
        while (headerPoint <= tailPoint) {
            this.swapArrayIndex(needSortArray, headerPoint, tailPoint);
            headerPoint++;
            tailPoint--;
        }
    }

    private void swapArrayIndex(int[] needSortArray, int headerPoint, int tailPoint) {
        int temp = needSortArray[headerPoint];
        needSortArray[headerPoint] = needSortArray[tailPoint];
        needSortArray[tailPoint] = temp;
    }
}
