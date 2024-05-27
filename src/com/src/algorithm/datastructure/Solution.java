package com.src.algorithm.datastructure;

import java.util.*;

class Solution {

    public int change(int amount, int[] coins) {
        // 使用队列来存储当前的金额和使用的硬币组合
        Queue<int[]> queue = new LinkedList<>();
        // 初始状态
        queue.add(new int[]{0});
        // 用来存储已经考虑过的组合
        Set<String> seen = new HashSet<>();

        int combinations = 0; // 组合数

        while (!queue.isEmpty()) {
            int[] currentCombination = queue.poll();
            int currentAmount = Arrays.stream(currentCombination).sum();

            // 如果当前金额正好等于目标金额
            if (currentAmount == amount) {
                combinations++;
                continue;
            } else if (currentAmount > amount) {
                continue;
            }

            // 尝试添加每种硬币
            for (int coin : coins) {
                int[] newCombination = Arrays.copyOf(currentCombination, currentCombination.length + 1);
                newCombination[newCombination.length - 1] = coin;
                Arrays.sort(newCombination); // 排序
                String key = Arrays.toString(newCombination);

                if (!seen.contains(key) && Arrays.stream(newCombination).sum() <= amount) {
                    queue.add(newCombination);
                    seen.add(key);
                }
            }
        }

        return combinations;
    }

}