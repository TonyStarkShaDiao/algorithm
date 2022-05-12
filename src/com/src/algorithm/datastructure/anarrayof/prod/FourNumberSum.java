package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/11
 */
public class FourNumberSum {
    List<List<Integer>> fourValuesAndResultsCollect = new ArrayList<>();

    public List<List<Integer>> Myself_FourNumberSum(int[] needAnalysisArray, int target) {
        Arrays.sort(needAnalysisArray);
        for (int needAnalysisArrayIndex = 0; needAnalysisArrayIndex < needAnalysisArray.length - 3; needAnalysisArrayIndex++) {
            if (needAnalysisArrayIndex > 0 && needAnalysisArray[needAnalysisArrayIndex] == needAnalysisArray[needAnalysisArrayIndex - 1]) {
                continue;
            } else {
                this.threeNumberSum(needAnalysisArray, needAnalysisArrayIndex + 1, target - needAnalysisArray[needAnalysisArrayIndex], needAnalysisArrayIndex);
            }
        }
        return fourValuesAndResultsCollect;
    }

    private void threeNumberSum(int[] needAnalysisArray, int headerPoint, int target, int firstIndex) {
        for (int needAnalysisArrayIndex = headerPoint; needAnalysisArrayIndex < needAnalysisArray.length; needAnalysisArrayIndex++) {
            if (needAnalysisArrayIndex > headerPoint && needAnalysisArray[needAnalysisArrayIndex] == needAnalysisArray[needAnalysisArrayIndex - 1]) {
                continue;
            } else {
                this.twoNumberSum(needAnalysisArray, needAnalysisArrayIndex + 1, needAnalysisArray.length - 1, target - needAnalysisArray[needAnalysisArrayIndex], firstIndex, needAnalysisArrayIndex);
            }
        }

    }

    private void twoNumberSum(int[] needAnalysisArray, int headerPoint, int tailPoint, int target, int firstIndex, int secondIndex) {
        while (headerPoint < tailPoint) {
            int currentSum = needAnalysisArray[headerPoint] + needAnalysisArray[tailPoint];
            if (currentSum == target) {
                List<Integer> currentResult = new ArrayList<>();
                currentResult.add(needAnalysisArray[firstIndex]);
                currentResult.add(needAnalysisArray[secondIndex]);
                currentResult.add(needAnalysisArray[headerPoint]);
                currentResult.add(needAnalysisArray[tailPoint]);
                fourValuesAndResultsCollect.add(currentResult);
                do {
                    headerPoint++;
                } while (headerPoint < tailPoint && needAnalysisArray[headerPoint] == needAnalysisArray[headerPoint - 1]);
            }
            if (currentSum < target) {
                headerPoint++;
            }
            ;
            if (currentSum > target) {
                tailPoint--;
            }
        }
    }
}
