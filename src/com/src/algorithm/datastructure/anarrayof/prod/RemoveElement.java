package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 删除元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/12
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int headerPoint = 0;
        int tailPoint = nums.length;
        while (headerPoint < tailPoint) {
            if (nums[headerPoint] == val) {
                nums[headerPoint] = nums[tailPoint - 1];
                tailPoint--;
            } else {
                headerPoint++;
            }
        }
        return headerPoint;
    }
}
