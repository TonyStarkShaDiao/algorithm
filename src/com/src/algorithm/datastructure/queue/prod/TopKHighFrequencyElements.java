package com.src.algorithm.datastructure.queue.prod;

import java.util.*;

/**
 * 前k个高频元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/10
 */
public class TopKHighFrequencyElements {

    /**
     * 我自队列顶级高频元素
     *
     * @param needFindArray   需要找到数组吗
     * @param firstFewElement 前几个元素
     * @return {@code int[]}
     */
    public int[] mySelf_QueueTopKHighFrequencyElements(int[] needFindArray, int firstFewElement) {
        Map<Integer, Integer> numberAndNumberCountContainer = new HashMap<>();
        for (int i = 0; i < needFindArray.length; i++) {
            numberAndNumberCountContainer.put(needFindArray[i], numberAndNumberCountContainer.getOrDefault(needFindArray[i], 0) + 1);
        }
        PriorityQueue<Integer> numberCountMinHeap = new PriorityQueue<>(Comparator.comparingInt(numberAndNumberCountContainer::get));
        for (Integer key : numberAndNumberCountContainer.keySet()) {
            numberCountMinHeap.add(key);
            if (numberCountMinHeap.size() > firstFewElement) {
                numberCountMinHeap.remove();
            }
        }
        int[] firstFewElementArray = new int[firstFewElement];
        for (int i = 0; i < firstFewElementArray.length; i++) {
            firstFewElementArray[i] = numberCountMinHeap.remove();
        }
        return firstFewElementArray;
    }

    public int[] bucketSort_QueueTopKHighFrequencyElements(int[] needFindArray, int firstFewElement) {
        Map<Integer, Integer> numberAndNumberCountContainer = new HashMap<>();
        for (int i = 0; i < needFindArray.length; i++) {
            numberAndNumberCountContainer.put(needFindArray[i], numberAndNumberCountContainer.getOrDefault(needFindArray[i], 0) + 1);
        }
        int[] firstFewElementElementResult = new int[firstFewElement];
        List<Integer>[] bucket = new List[needFindArray.length + 1];
        for (Integer number : numberAndNumberCountContainer.keySet()) {
            Integer currentNumberCount = numberAndNumberCountContainer.get(number);
            if (bucket[currentNumberCount] == null) {
                bucket[currentNumberCount] = new ArrayList<>();
            }
            bucket[currentNumberCount].add(number);
        }
        int firstFewElementElementResultIndex = 0;
        for (int bucketIndex = bucket.length - 1; bucketIndex > 0; bucketIndex--) {
            List<Integer> integers = bucket[bucketIndex];
            if (integers == null) {
                continue;
            }
            for (Integer numericalSymbols : integers) {
                firstFewElementElementResult[firstFewElementElementResultIndex++] = numericalSymbols;
                if (firstFewElementElementResultIndex == firstFewElement) {
                    return firstFewElementElementResult;
                }
            }
        }
        return firstFewElementElementResult;
    }

    public int[] topKFrequent(int[] needFindArray, int firstFewElement) {
        List<Integer> res = new ArrayList();
        int[] result = new int[firstFewElement];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < needFindArray.length; i++) {
            map.put(needFindArray[i], map.getOrDefault(needFindArray[i], 0) + 1);
        }
        List<Integer>[] list = new List[needFindArray.length + 1];
        for (int key : map.keySet()) {
            Integer i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        for (int i = list.length - 1; i >= 0 && res.size() < firstFewElement; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }
        for (int i = 0; i < firstFewElement; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
