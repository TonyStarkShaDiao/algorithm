package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 搜索插入位置
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/12
 *
 */
public class SearchInsertionLocation {
    public int binarySearchSearchInsertionLocation(int[] nums, int target) {
        int tailPoint = nums.length - 1;
        int headPoint = 0;
        while (headPoint <= tailPoint) {
            int midPoint = headPoint + (tailPoint - headPoint) / 2;
            if (nums[midPoint] == target) {
                return midPoint;
            } else if (nums[midPoint] > target) {
                tailPoint = midPoint - 1;
            } else {
                headPoint = midPoint + 1;
            }
        }
        return headPoint;
    }
}
