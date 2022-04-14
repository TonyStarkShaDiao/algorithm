package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为某个值得子数组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/14
 */

public class SumForSomeValueSubarray {

    /**
     * 我自己哈希和子数组值
     *
     * @param specifiedArray  指定数组
     * @param comparingValues 比较值
     * @return int
     */
    public int mySelf_HashSumForSomeValueSubarray(int[] specifiedArray, int comparingValues) {
        int sumCount = 0;
        int prefixSum = 0;
        Map<Integer, Integer> sumOfPrefixResult = new HashMap<>();
        sumOfPrefixResult.put(0, 1);
        for (int i = 0; i < specifiedArray.length; i++) {
            prefixSum = prefixSum + specifiedArray[i];
            if (sumOfPrefixResult.containsKey(prefixSum - comparingValues)) {
                sumCount = sumCount + sumOfPrefixResult.get(prefixSum - comparingValues);
            }
            sumOfPrefixResult.put(prefixSum, sumOfPrefixResult.getOrDefault(prefixSum, 0) + 1);
        }
        return sumCount;
    }
}
