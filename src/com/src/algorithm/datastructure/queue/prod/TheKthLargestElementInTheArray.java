package com.src.algorithm.datastructure.queue.prod;

import java.util.PriorityQueue;

/**
 * 数组中第k个最大元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/10
 */
public class TheKthLargestElementInTheArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int myself_findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer elementValue : nums) {
            minHeap.add(elementValue);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}