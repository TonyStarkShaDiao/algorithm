package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;

/**
 * 没有重叠区间
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/11
 *
 */

public class NoOverlappingInterval {
    public int myself_NoOverlappingInterval(int[][] intervalsArray) {
        Arrays.sort(intervalsArray, (previousIntervalArray, currentInterValArray) -> previousIntervalArray[0] - currentInterValArray [0]);
        int NoOverlappingIntervalCount =0;
        int  currentIntervalArrayMinValue = intervalsArray[0][1];
        for (int intervalsArrayIndex = 1; intervalsArrayIndex < intervalsArray.length; intervalsArrayIndex++) {
            if (currentIntervalArrayMinValue<=intervalsArray[intervalsArrayIndex][0]) {
                currentIntervalArrayMinValue = intervalsArray[intervalsArrayIndex][1];
            }else {
                currentIntervalArrayMinValue=Math.min(currentIntervalArrayMinValue,intervalsArray[intervalsArrayIndex][1]);
                NoOverlappingIntervalCount++;
            }
        }
 return NoOverlappingIntervalCount;
    }
}
