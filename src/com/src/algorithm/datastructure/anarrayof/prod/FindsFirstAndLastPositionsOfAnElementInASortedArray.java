package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 查找已排序数组中元素第一个和最后一个位置
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/13
 */
public class FindsFirstAndLastPositionsOfAnElementInASortedArray {

    public int[] myself_SearchRange(int[] nums, int target) {
        int headerPoint = 0;
        int tailPoint = nums.length - 1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        while (headerPoint <= tailPoint) {
            int midPoint = headerPoint + (tailPoint - headerPoint) / 2;
            if (nums[midPoint] == target) {
                if (nums[headerPoint] == target && nums[tailPoint] == target) {
                    return new int[]{headerPoint, tailPoint};
                }
                if (nums[headerPoint] != target) {
                    headerPoint++;
                }
                if (nums[tailPoint] != target) {
                    tailPoint--;
                }
            } else if (nums[midPoint] > target) {
                tailPoint = midPoint - 1;
            } else {
                headerPoint = midPoint + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] myself_FindsFirstAndLastPositionsOfAnElementInASortedArray(int[] nums, int target) {
        int headerPoint = 0;
        int tailPoint = nums.length - 1;
        int index = 0;
        while (headerPoint <= tailPoint) {
            int midPoint = headerPoint + (tailPoint - headerPoint) / 2;
            if (nums[midPoint] == target) {
                index = midPoint;
                int headerIndex = Integer.MAX_VALUE;
                int tailIndex = Integer.MIN_VALUE;
                for (int i = index; i >= 0; i--) {
                    if (nums[i] == target) {
                        headerIndex = i;
                    }
                }
                for (int i = index; i < nums.length; i++) {
                    if (nums[i] == target) {
                        tailIndex = i;
                    }
                }
                if (headerIndex != Integer.MAX_VALUE && tailIndex != Integer.MIN_VALUE) {
                    return new int[]{headerIndex, tailIndex};
                }
                break;
            } else if (nums[midPoint] > target) {
                tailPoint = midPoint - 1;
            } else {
                headerPoint = midPoint + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
