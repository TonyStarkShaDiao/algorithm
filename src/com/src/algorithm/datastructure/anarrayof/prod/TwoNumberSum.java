package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/18
 * 给定一个<<整数数组 nums>>>>和一个<<整数目标值 target>>，
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumberSum {

    /**
     * 我自己哈希
     * 我自己哈希方法
     *
     * @param ArraysIndexToSum 数组索引和
     * @param needArrays       需要数组
     * @return {@link int[]}
     */
    public int[] mySelf_Hash(int[] needArrays, int ArraysIndexToSum) {
        if (needArrays.length == 0) {
            return new int[1];
        }
        Map<Integer, Integer> ResultCache = new HashMap<>();
        for (int i = 0; i < needArrays.length; i++) {
            Integer arraysIndex = ResultCache.get(ArraysIndexToSum - needArrays[i]);
            if (arraysIndex != null) {
                return new int[]{arraysIndex, i};
            }
            ResultCache.put(needArrays[i], i);
        }
        return null;
    }

}
