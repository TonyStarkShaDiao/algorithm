package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 两个有序数组合并
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/18
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoOrderlyArrayMerge {


    /**
     * 我自己双指针
     *
     * @param firstOneArrays       第一个数组
     * @param firstOneArraysLength 第一个数组长度 一开始-1是因为数组下标其实为长度-1 nums1.length == m + n 这尼玛是毛的提示 这明明是其那题
     * @param secondArrays         第二个数组要小于第一个素组
     * @param secondArraysLength   第二个数组长度 一开始-1是因为数组下标其实为长度-1
     */
  public   int [] mySelf_DoublePointer(int[] firstOneArrays, int firstOneArraysLength, int[] secondArrays, int secondArraysLength) {
     int []  firstOneArraysCopy= new int[firstOneArraysLength+secondArraysLength];

        firstOneArraysLength--;
        secondArraysLength--;
        while (secondArraysLength >= 0) {
            //m >= 0是避免 nums1={0}的情况
            if (firstOneArraysLength >= 0 && firstOneArrays[firstOneArraysLength] > secondArrays[secondArraysLength]) {
                //nums1 > nums2,则把nums1[m]放到nums1数组后面,m再自减一
                firstOneArrays[(firstOneArraysLength + secondArraysLength + 1)] = firstOneArrays[firstOneArraysLength--];
            } else {
                //nums2 >= nums1,则把nums2[n]放到nums1数组后面,n再自减一
                firstOneArrays[(firstOneArraysLength + secondArraysLength + 1)] = secondArrays[secondArraysLength--];
            }

        }
        return firstOneArrays;
    }
    public   int [] mySelf_ReverseDoublePointer(int[] firstOneArrays, int firstOneArraysLength, int[] secondArrays, int secondArraysLength) {
     firstOneArraysLength--;
     secondArraysLength--;
      while (secondArraysLength>-1){
          if (firstOneArraysLength>-1&&firstOneArrays[firstOneArraysLength]>secondArrays[secondArraysLength]){
              firstOneArrays[firstOneArraysLength+secondArraysLength+1]=firstOneArrays[firstOneArraysLength--];
          }else {
              firstOneArrays[(firstOneArraysLength+secondArraysLength+1)]=secondArrays[secondArraysLength--];
          }
      }
      return firstOneArrays;
    }

}
