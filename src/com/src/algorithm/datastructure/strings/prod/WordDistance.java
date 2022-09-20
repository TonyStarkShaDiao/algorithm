package com.src.algorithm.datastructure.strings.prod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词距离
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/28
 */
public class WordDistance {
    public int mySelf_binarySearchWordDistance(String[] wordArray, String FirstOneWord, String SecondOneWord) {
        List<Integer> firstOneWordAppearIndexList = new ArrayList<>();
        List<Integer> secondOneWordAppearIndexList = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].equals(FirstOneWord)) {
                firstOneWordAppearIndexList.add(i);
            } else if (wordArray[i].equals(SecondOneWord)) {
                secondOneWordAppearIndexList.add(i);
            }
        }
        Arrays.sort(firstOneWordAppearIndexList.toArray());
        int twoWordsMiniMumSpecific = Integer.MAX_VALUE;
        for (Integer secondOneWordIndex : secondOneWordAppearIndexList) {
            int leftBorderMaxValue = this.binarySearchFindLeftBoundaryMaxValue(firstOneWordAppearIndexList, secondOneWordIndex);
            int rightBorderMinValue = this.binarySearchFindRightBoundaryMinValue(firstOneWordAppearIndexList, secondOneWordIndex);
            int leftBorderIntervalDistance = Math.abs(secondOneWordIndex - leftBorderMaxValue);
            int rightBorderIntervalDistance = Math.abs(rightBorderMinValue - secondOneWordIndex);
            twoWordsMiniMumSpecific = Math.min(twoWordsMiniMumSpecific, Math.min(leftBorderIntervalDistance, rightBorderIntervalDistance));
        }
        return twoWordsMiniMumSpecific;
    }

    private int binarySearchFindRightBoundaryMinValue(List<Integer> firstOneWordAppearIndexList, Integer tagert) {
        int headerPoint = -1;
        int tailPoint = firstOneWordAppearIndexList.size();
        while (headerPoint + 1 < tailPoint) {
            int middlePoint = headerPoint + ((tailPoint - headerPoint) >> 1);
            if (firstOneWordAppearIndexList.get(middlePoint) <= tagert) {
                headerPoint = middlePoint;
            } else {
                tailPoint = middlePoint;
            }
        }
        if (headerPoint != -1 && firstOneWordAppearIndexList.get(headerPoint).equals(tagert)) {
            return tailPoint;
        }
        return -1;
    }

    private int binarySearchFindLeftBoundaryMaxValue(List<Integer> firstOneWordAppearIndexList, Integer tagert) {
        int headerPoint = -1;
        int tailPoint = firstOneWordAppearIndexList.size();
        while (headerPoint + 1 < tailPoint) {
            int middlePoint = headerPoint + ((tailPoint - headerPoint) >> 1);
            if (firstOneWordAppearIndexList.get(middlePoint) < tagert) {
                headerPoint = middlePoint;
            } else {
                tailPoint = middlePoint;
            }
        }
        if (tailPoint != firstOneWordAppearIndexList.size() && firstOneWordAppearIndexList.get(tailPoint).equals(tagert)) {
            return headerPoint;
        }
        return -1;
    }
}
//算法
//
//二分
//   只要明白 1ower bound 是找第一个>=target 的位置， upper bound 是找第一个
//＞ target 的位置，灵活变动即可。
//
//
//★ 模板六
//模板简介
//构造左右边界，蓝红二分，生动形象，界限分明。
//
//蓝红二分法：蓝红二分法单模板秒杀二分查找
//
//模板代码
//C++JavaPython
//
//int binarySearch(int[] nums, int target) {
//    if (nums == null || nums.length == 0)
//        return -1;
//
//    int left = -1, right = nums.length;
//    while (left + 1 < right){
//        // Prevent (left + right) overflow
//        int mid = left + (right - left) / 2;
//        if (nums[mid] == target) {
//            return mid;
//        } else if (nums[mid] < target) {
//            left = mid;
//        } else {
//            right = mid;
//        }
//    }
//
//    // Post-processing:
//    // End Condition: left + 1 == right
//    return -1;
//}
//查找等于 targettarget 的第一个元素下标，即查找 targettarget 左边界。
//
//C++JavaPython
//
//int binarySearch(int[] nums, int target) {
//    if (nums == null || nums.length == 0)
//        return -1;
//    int left = -1, right = nums.length;
//    while (left + 1 < right) {
//        // Prevent (left + right) overflow
//        int mid = left + (right - left) / 2;
//        if (nums[mid] < target) {
//            left = mid;
//        } else {
//            right = mid;
//        }
//    }
//    // Post-processing:
//    // End Condition: left + 1 == right
//    if(right != nums.length && nums[right] == target) return right;
//    return -1;
//}
//查找等于 targettarget 的最后一个元素下标，即查找 targettarget 右边界。
//
//C++JavaPython
//
//int binarySearch(int[] nums, int target) {
//    if (nums == null || nums.length == 0)
//        return -1;
//    int left = -1, right = nums.length;
//    while (left + 1 < right) {
//        // Prevent (left + right) overflow
//        int mid = left + (right - left) / 2;
//        if (nums[mid] <= target) {
//            left = mid;
//        } else {
//            right = mid;
//        }
//    }
//    // Post-processing:
//    // End Condition: left + 1 == right
//    if(left != -1 && nums[left] == target) return left;
//    return -1;
//}
//区分语法
//初始条件：left = -1, right = n
//循环条件：left + 1 < right
//向左查找：right = mid
//向右查找：left = mid
//mid指针计算：左右指针和折半向下取整
//
//模板口诀
//左开右开，向下取整，左定右定，相邻终止。
//
//使用说明
//二分查找的的高级方法。
//需要进行后处理。
//
//
//
//作者：随心源
//链接：https://leetcode.cn/circle/discuss/ObmjbJ/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。