package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 最大子数组求和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/13
 */
public class MaxSubArraySum {
    /**
     * 我的动态规划
     * 大概的意识是说
     * 上一轮的最大和与上一轮的最大和+当前便利数组元素的值 取 最大值
     * 然后再将前一个最大值与当前最大值做个比较
     *
     * @param NeedToFindForArray 需要找到数组中
     * @return int
     */

    public int mySelf_dynamicProgramming(int[] NeedToFindForArray) {
        int onAMaxValue = 0;
        int currentMaxValue = NeedToFindForArray[0];
        for (int value : NeedToFindForArray) {
            onAMaxValue = Math.max(onAMaxValue + value, value);
            currentMaxValue = Math.max(currentMaxValue, onAMaxValue);
        }
        return currentMaxValue;
    }

    /**
     * 我自己贪心算法
     *
     * @param NeedToFindForArray 需要找到数组中
     * @return int
     */
    public int mySelf_greedyAlgorithm(int[] NeedToFindForArray) {
       int sum =0;
       int maxArrayValue=Integer.MIN_VALUE;
        for (int i = 0; i < NeedToFindForArray.length; i++) {
            sum= Math.max(sum, 0);
            sum+=NeedToFindForArray[i];
            maxArrayValue=Math.max(sum, maxArrayValue);
        }
        return maxArrayValue;
    }

}