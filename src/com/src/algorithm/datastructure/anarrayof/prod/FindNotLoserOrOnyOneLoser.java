package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.*;
import java.util.stream.Collectors;

public class FindNotLoserOrOnyOneLoser {

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> loserhashMap = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        // 统计一个的人的失败次数0 或者为1 的人
        for (int[] match : matches) {
            int winnerId = match[0];
            int loserId = match[1];
            loserhashMap.merge(loserId, 1, Integer::sum);
            winners.add(winnerId);
        }
        winners.removeIf(item -> loserhashMap.containsKey(item));
        // loserhashMap取key 转换为list 过滤 value >1
        List<Integer> onceLosers = loserhashMap.keySet().stream().filter(key -> loserhashMap.get(key) == 1).collect(Collectors.toList());
        List<Integer> winnersArray = new ArrayList<>(winners);
        // winnersArray 升序 排序
        winnersArray.sort(Integer::compareTo);
        onceLosers.sort(Integer::compareTo);
        result.add(winnersArray);
        result.add(onceLosers);
        return result;
    }

    public static void main(String[] args) {
        int[][] matches = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9}
        };

        List<List<Integer>> winners = findWinners(matches);

        long l = System.currentTimeMillis();
        long b = System.currentTimeMillis();
        System.out.println(System.nanoTime());
        System.out.println("winners = " + l);
        System.out.println("假设中间有一行");
        System.out.println("w = " + b);


    }

}
