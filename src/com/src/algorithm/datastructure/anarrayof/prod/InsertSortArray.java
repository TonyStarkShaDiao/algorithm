package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 插入排序数组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */
public class InsertSortArray {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public int[] MySelf_insertSortArray(int[] unorderedArray) {
        int unorderedArrayLength = unorderedArray.length;
        for (int unorderedArrayLengthIndex = 1; unorderedArrayLengthIndex < unorderedArrayLength; unorderedArrayLengthIndex++) {
            int temp = unorderedArray[unorderedArrayLengthIndex];
            int totalNumberOfSortedArrays = unorderedArrayLengthIndex;
            while (totalNumberOfSortedArrays > 0 && unorderedArray[totalNumberOfSortedArrays - 1] > temp) {
                unorderedArray[totalNumberOfSortedArrays] = unorderedArray[totalNumberOfSortedArrays - 1];
                totalNumberOfSortedArrays--;
            }
            unorderedArray[totalNumberOfSortedArrays] = temp;
        }
        return unorderedArray;
    }

}
