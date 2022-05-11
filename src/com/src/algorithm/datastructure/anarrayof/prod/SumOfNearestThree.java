package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/11
 */
public class SumOfNearestThree {
    public int mySelf_DoubleSumOfNearestThree(int[] needAnalysisArray, int target) {
        int nearestValue = Integer.MAX_VALUE - target;
        Arrays.sort(needAnalysisArray);
        for (int needAnalysisArrayIndex = 0; needAnalysisArrayIndex < needAnalysisArray.length - 2; needAnalysisArrayIndex++) {
            int tailPoint = needAnalysisArrayIndex + 1, headPoint = needAnalysisArray.length - 1;
            while (tailPoint < headPoint) {
                int sum = needAnalysisArray[needAnalysisArrayIndex] + needAnalysisArray[tailPoint] + needAnalysisArray[headPoint];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (Math.abs(sum - target) < Math.abs(nearestValue - target)) {
                        nearestValue = sum;
                    }
                    tailPoint++;
                } else {
                    if (Math.abs(sum - target) < Math.abs(nearestValue - target)) {
                        nearestValue = sum;
                    }
                    headPoint--;
                }
            }
        }
        return nearestValue;
    }
}
