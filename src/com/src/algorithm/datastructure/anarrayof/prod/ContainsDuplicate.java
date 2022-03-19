package com.src.algorithm.datastructure.anarrayof.prod;//给定一个整数数组，判断是否存在重复元素。
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 排序 👍 594 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 包含重复
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/12
 */
public class ContainsDuplicate {
    /**
     * 我自己使用散列映射
     * 我自己写找到包含重复
     * 9s 有点慢
     *
     * @param NeedToFindForArray 需要找到的数组
     * @return boolean
     */

    public boolean mySelf_UsedHashMap(int[] NeedToFindForArray) {
        HashMap<Integer, Boolean> arrayResultCache = new HashMap<>(NeedToFindForArray.length);
        if (judgeOfArraysNumberlessThanTwo(NeedToFindForArray)) {
            return false;
        }

        for (int i = 0; i < NeedToFindForArray.length; i++) {
            if (arrayResultCache.containsKey(NeedToFindForArray[i])) {
                return true;
            } else {
                arrayResultCache.put(NeedToFindForArray[i], true);
            }
        }
        return false;
    }

    public boolean mySelf_UsedHashSet(int[] NeedToFindForArray) {
        Set<Integer> arrayResultCache = new HashSet<>();

        boolean judgedResult = judgeOfArraysNumberlessThanTwo(NeedToFindForArray);
        if (judgedResult) {
            return false;
        }
        judgedResult=true;
        for (int i = 0; i < NeedToFindForArray.length; i++) {
            judgedResult=judgedResult&& arrayResultCache.add(NeedToFindForArray[i]);
        }
        return !judgedResult;


    }

    /**
     * @param NeedToFindForArray 需要找到数组中
     * @return boolean
     */
    private boolean judgeOfArraysNumberlessThanTwo(int[] NeedToFindForArray) {
        if (NeedToFindForArray.length == 0 || NeedToFindForArray.length == 1) {
            return true;
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
