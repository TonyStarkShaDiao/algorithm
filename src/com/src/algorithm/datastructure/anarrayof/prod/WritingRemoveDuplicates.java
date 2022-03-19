package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 删除重复元素
 * leetcode 26 简单题
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/10
 */
public class WritingRemoveDuplicates {

    /**
     * 一个自我写作删除重复值
     * 一个自己写的删除重复值的函数方法
     * 尼玛 审题很重要
     * 第一个是有序数组!!!!
     * 第二个是 返回删除后数组的新长度 这尼玛就是个坑啊  这尼玛不是要你删除重复的 就只是要你找下的有多少不重复的
     * 元,不重复数量就++ 最后返回这个数值的长度就可以了 根本就不是让你返回数组的长度
     * 出题的人该拉出去毙了
     *
     * @param containRepeatingElementArray 包含重复元素数组
     * @return int
     */
    public int oneSelfWritingRemoveDuplicates(int[] containRepeatingElementArray) {
        if (containRepeatingElementArray.length == 0 || containRepeatingElementArray.length == 1) {
            return containRepeatingElementArray.length;
        }
        int slowPointer = 0;
        int fastPointer = 1;
        for (; fastPointer < containRepeatingElementArray.length; fastPointer++) {
            if (containRepeatingElementArray[slowPointer] != containRepeatingElementArray[fastPointer]) {
                slowPointer++;
                containRepeatingElementArray[slowPointer] = containRepeatingElementArray[fastPointer];
            }
        }
        return slowPointer + 1;
    }


}
