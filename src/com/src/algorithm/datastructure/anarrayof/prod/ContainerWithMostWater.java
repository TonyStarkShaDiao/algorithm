package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 盛水容器
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/12
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int currentMostMeasureOfArea = Integer.MIN_VALUE;
        int tailPoint = height.length - 1;
        int headPoint = 0;
        while (headPoint < tailPoint) {
            int currentTotalArea = Math.min(height[headPoint], height[tailPoint]) * (tailPoint - headPoint);
            currentMostMeasureOfArea = Math.max(currentMostMeasureOfArea, currentTotalArea);
            if (height[headPoint] <= height[tailPoint]) {
                headPoint++;
            } else {
                tailPoint--;
            }
        }
        return currentMostMeasureOfArea;
    }
}
