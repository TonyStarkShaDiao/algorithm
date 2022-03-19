package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组交集||350
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 。
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/25
 */
public class IntersectionOfTwoArrays {
    /**
     * 我自己列两个数组交集
     * 要确定拿数组多的 和数组少的进行
     *
     * @param firstOneArrayParam 第一个数组
     * @param secondArrayParam   第二个数组
     * @return {@link int[]}
     */
    public int[] mySelf_HashIntersectionOfTwoArrays(int[] firstOneArrayParam, int[] secondArrayParam) {
        if (secondArrayParam.length > firstOneArrayParam.length) {
            mySelf_HashIntersectionOfTwoArrays(secondArrayParam, firstOneArrayParam);
        }
        Map<Integer, Integer> elementCounter = new HashMap<>(firstOneArrayParam.length);
        for (int firstArrayIndex = 0; firstArrayIndex < firstOneArrayParam.length; firstArrayIndex++) {
            if (!elementCounter.containsKey(firstOneArrayParam[firstArrayIndex])) {
                elementCounter.put(firstOneArrayParam[firstArrayIndex], 1);
            } else {
                Integer firstResultCount = elementCounter.get(firstOneArrayParam[firstArrayIndex]);
                elementCounter.put(firstOneArrayParam[firstArrayIndex], ++firstResultCount);
            }
        }
        int[] tempResult = new int[firstOneArrayParam.length];
        int tempResultPointer = 0;
        for (int secondArrayIndex = 0; secondArrayIndex < secondArrayParam.length; secondArrayIndex++) {
            if (elementCounter.containsKey(secondArrayParam[secondArrayIndex])) {
                Integer elementCount = elementCounter.get(secondArrayParam[secondArrayIndex]);
                if (elementCount > 0) {
                    tempResult[tempResultPointer] = secondArrayParam[secondArrayIndex];
                    elementCounter.put(secondArrayParam[secondArrayIndex], --elementCount);
                    tempResultPointer++;
                }
            }
        }
        return Arrays.copyOfRange(tempResult, 0, tempResultPointer);
    }

    /**
     * 我自己双指针两个数组交集
     *
     * @param firstOneArrayParam 第一个数组参数
     * @param secondArrayParam   第二个数组参数
     * @return {@link int[]}
     */
    public int[] mySelf_doublePointerIntersectionOfTwoArrays(int[] firstOneArrayParam, int[] secondArrayParam) {
        Arrays.sort(firstOneArrayParam);
        Arrays.sort(secondArrayParam);
        int firstArrayPointer = 0, secondArrayPointer = 0;
        int firstArrayLength = firstOneArrayParam.length;
        int secondArrayLength = secondArrayParam.length;
        int[] tempArrayResult = new int[Math.min(secondArrayLength, firstArrayLength)];
        int tempArrayPointer=0;
        while (firstArrayLength > firstArrayPointer && secondArrayLength > secondArrayPointer) {
            if (firstOneArrayParam[firstArrayPointer] > secondArrayParam[secondArrayPointer]) {
                secondArrayPointer++;
            } else if (secondArrayParam[secondArrayPointer] > firstOneArrayParam[firstArrayPointer]) {
                firstArrayPointer++;
            } else {
                tempArrayResult[tempArrayPointer]=secondArrayParam[secondArrayPointer];
                tempArrayPointer++;
                secondArrayPointer++;
                firstArrayPointer++;
            }
        }
        return Arrays.copyOfRange(tempArrayResult, 0, tempArrayPointer);
    }
}
