package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/14
 */
public class FullArrangement {
    public List<List<Integer>> mySelf_swapArrayFullArrangement(int[] needAnalysisArray) {
        if (needAnalysisArray == null || needAnalysisArray.length == 0 || needAnalysisArray.length == 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        this.dfs(result, needAnalysisArray, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] needAnalysisArray, int needAnalysisArrayIndex) {
        if (needAnalysisArrayIndex == needAnalysisArray.length) {
            List<Integer> temp = new ArrayList<>();
            for (int currentNumber : needAnalysisArray) {
                temp.add(currentNumber);
            }
            result.add(temp);
            return;
        }
        for (int currentNeedAnalysisArrayIndex = needAnalysisArrayIndex; currentNeedAnalysisArrayIndex < needAnalysisArray.length; currentNeedAnalysisArrayIndex++) {
            this.swapArray(needAnalysisArray, needAnalysisArrayIndex, currentNeedAnalysisArrayIndex);
            this.dfs(result, needAnalysisArray, needAnalysisArrayIndex + 1);
            this.swapArray(needAnalysisArray, needAnalysisArrayIndex, currentNeedAnalysisArrayIndex);
        }
    }

    private void swapArray(int[] needAnalysisArray, int needAnalysisArrayIndex, int currentNeedAnalysisArrayIndex) {
        int temp = needAnalysisArray[needAnalysisArrayIndex];
        needAnalysisArray[needAnalysisArrayIndex] = needAnalysisArray[currentNeedAnalysisArrayIndex];
        needAnalysisArray[currentNeedAnalysisArrayIndex] = temp;
    }
}
