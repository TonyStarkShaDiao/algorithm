package com.src.algorithm.datastructure.queue.prod;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 按字符频率排序
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/11
 */
public class SortByCharacterFrequency {

    /**
     * 我自己的桶排序通过字符频率
     *
     * @param needSortCharacterString 需要排序字符串吗
     * @return {@code String}
     */
    public String Myself_bucketSortByCharacterFrequency(String needSortCharacterString) {
        if (needSortCharacterString == null || needSortCharacterString.length() < 2) {
            return needSortCharacterString;
        }
        int[] numberFrequency = new int[128];
        char[] chars = needSortCharacterString.toCharArray();
        int bucketTotal = Integer.MIN_VALUE;
        for (int charsIndex = 0; charsIndex < chars.length; charsIndex++) {
            numberFrequency[chars[charsIndex]]++;
            bucketTotal = Math.max(bucketTotal, numberFrequency[chars[charsIndex]]);
        }
        List<Character>[] bucket = new ArrayList[bucketTotal + 1];
        for (int number = 0; number < 128; number++) {
            if (numberFrequency[number] == 0) {
                continue;
            }
            if (bucket[numberFrequency[number]] == null) {
                bucket[numberFrequency[number]] = new ArrayList<>();
            }
            bucket[numberFrequency[number]].add((char) number);
        }
        StringBuilder sortCharacterStringResult = new StringBuilder();
        for (int bucketNumberFrequency = bucket.length - 1; bucketNumberFrequency >= 0; bucketNumberFrequency--) {
            if (bucket[bucketNumberFrequency] == null) {
                continue;
            }
            for (Character character : bucket[bucketNumberFrequency]) {
                while (numberFrequency[character] > 0) {
                    sortCharacterStringResult.append(character);
                    numberFrequency[character]--;
                }
            }
        }
        return sortCharacterStringResult.toString();
    }

    /**
     * 我自己的最大值堆分类通过字符频率
     *
     * @param needSortCharacterString 需要排序字符串吗
     * @return {@code String}
     */
    public String Myself_MaxHeapSortByCharacterFrequency(String needSortCharacterString) {
        if (needSortCharacterString == null || needSortCharacterString.length() < 2) {
            return needSortCharacterString;
        }
        int[] numberFrequency = new int[128];
        char[] chars = needSortCharacterString.toCharArray();
        for (int charterIndex = 0; charterIndex < chars.length; charterIndex++) {
            numberFrequency[chars[charterIndex]]++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((firstOne, secondOne) -> numberFrequency[secondOne] - numberFrequency[firstOne]);
        for (int i = 0; i < 128; i++) {
            if (numberFrequency[i] != 0) {
                maxHeap.offer((char) i);
            }
        }
        StringBuilder sortCharacterStringResult = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character characterString = maxHeap.poll();
            while (numberFrequency[characterString] > 0) {
                sortCharacterStringResult.append(characterString);
                numberFrequency[characterString]--;
            }
        }
        return sortCharacterStringResult.toString();
    }
}
