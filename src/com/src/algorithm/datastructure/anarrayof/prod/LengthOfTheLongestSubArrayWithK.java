package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的最长子数组长度
 * 325
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/09/20
 */
public class LengthOfTheLongestSubArrayWithK {

    /**
     * 最大子阵列长度
     *
     * @param needFindArray 需要查找数组
     * @param sumResult     求和结果
     * @return int
     */
    public int maxSubArrayLen(int[] needFindArray, int sumResult) {
        Map<Integer, Integer> subArraySumAndIndexCollect = new HashMap<>();
        int currentSum = 0;
        int maxArrayLengthResult = 0;
        subArraySumAndIndexCollect.put(0, -1);
        for (int currentNeedFindArrayIndex = 0; currentNeedFindArrayIndex < needFindArray.length; currentNeedFindArrayIndex++) {
            currentSum += needFindArray[currentNeedFindArrayIndex];
            //当前子数组之和-目标值=之前子数组之和,如果之前子数组之和存在,则当前子数组之和-之前子数组之和=目标值
            if (subArraySumAndIndexCollect.containsKey(currentSum - sumResult)) {
                //当前子数组长度=当前子数组索引-之前子数组索引
                maxArrayLengthResult = Math.max(maxArrayLengthResult, currentNeedFindArrayIndex - subArraySumAndIndexCollect.get(currentSum - sumResult));
            }
            if (!subArraySumAndIndexCollect.containsKey(currentSum)) {
                subArraySumAndIndexCollect.put(currentSum, currentNeedFindArrayIndex);
            }
        }
        return maxArrayLengthResult;
    }

    public int maxSubArrayLen_V2(int[] needFindArray, int sumResult) {
        int maxArrayLength = 0;
        int[] subSumArray = new int[needFindArray.length + 1];
        Map<Integer, Integer> subArraySumAndIndexCollect = new HashMap<>();
        subArraySumAndIndexCollect.put(0, 0);
        for (int i = 1; i < needFindArray.length; i++) {
            int beforeCurrentElementSum = subSumArray[i - 1];
            subSumArray[i] = beforeCurrentElementSum + needFindArray[i - 1];
            int currentElementSum = subSumArray[i];
            if (!subArraySumAndIndexCollect.containsKey(currentElementSum)) {
                subArraySumAndIndexCollect.put(currentElementSum, i);
            }
        }
        for (int currentLastIndex = subSumArray.length - 1; currentLastIndex >= 0; currentLastIndex--) {
            int currentLastSubArraySum = subSumArray[currentLastIndex];
            int difference = currentLastSubArraySum - sumResult;
            if (subArraySumAndIndexCollect.containsKey(difference)) {
                maxArrayLength = Math.max(maxArrayLength, currentLastIndex - subArraySumAndIndexCollect.get(difference));
            }
        }
        return maxArrayLength;
    }
}
