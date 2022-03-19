

class Solution {
    /**
     * 解题思路双指针
     * 每当指针值不同时，慢指针更改
     *
     * @param nums
     * @return //给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * //
     * // 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 ¡
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 一个自己写的删除重复值的函数方法
     * 尼玛 审题很重要
     * 第一个是有序数组!!!!
     * 第二个是 返回删除后数组的新长度 这尼玛就是个坑啊  这尼玛不是要你删除重复的 就只是要你找下的有多少不重复的
     * 元,不重复数量就++ 最后返回这个数值的长度就可以了 根本就不是让你返回数组的长度
     * 出题的人该拉出去毙了
     *
     * @param nums 数组
     * @return intj
     */
    public static int oneSelfWritingRemoveDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int slowPointer = 0;
        int quickPointer = 1;
        for (; quickPointer < nums.length; quickPointer++) {
            if (nums[quickPointer] != nums[slowPointer]) {
                slowPointer++;
                nums[slowPointer] = nums[quickPointer];
            }
        }
        return slowPointer + 1;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6, 6, 7,};
        System.out.println(oneSelfWritingRemoveDuplicates(nums));
    }
}
