package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并范围内
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/05
 */
public class MergeRange {
    public int[][] myself_forFirstTime_merge(int[][] needIntervalArray) {
        intervalArraySort(needIntervalArray);
        List<int[]> intervalCollect = new ArrayList<>();
        for (int i = 0; i < needIntervalArray.length; i++) {
            int[] currentIntervalArray = needIntervalArray[i];
            if (intervalCollect.isEmpty()) {
                intervalCollect.add(currentIntervalArray);
            }
            int[] lastIntervalElementArray = intervalCollect.get(intervalCollect.size() - 1);
            int currentIntervalArrayLeftBorder = currentIntervalArray[0];
            int lastIntervalElementRightBorder = lastIntervalElementArray[1];
            if (lastIntervalElementRightBorder >= currentIntervalArrayLeftBorder) {
                int currentIntervalArrayRightBorder = currentIntervalArray[1];
                lastIntervalElementArray[1] = Math.max(currentIntervalArrayRightBorder, lastIntervalElementRightBorder);
            } else {
                intervalCollect.add(currentIntervalArray);

            }

        }
        return intervalCollect.toArray(new int[intervalCollect.size()][]);
    }
    public int[][] myself_secondTime_merge(int[][] needIntervalArray) {
        this.intervalArraySort(needIntervalArray);
        List<int[]> mergeIntervalCollect = new ArrayList<>();
        for (int i = 0; i < needIntervalArray.length; i++) {
            int[] currentNeedCheckMergeIntervalArray = needIntervalArray[i];
            if (mergeIntervalCollect.isEmpty()){
                mergeIntervalCollect.add(currentNeedCheckMergeIntervalArray);
            }
            int[] previousCheckedMergeIntervalArray = mergeIntervalCollect.get(mergeIntervalCollect.size() - 1);
            int previousCheckedMergeIntervalArrayRightBorder = previousCheckedMergeIntervalArray[1];
            int currentNeedCheckMergeIntervalArrayLeftBorder = currentNeedCheckMergeIntervalArray[0];
            if (previousCheckedMergeIntervalArrayRightBorder>=currentNeedCheckMergeIntervalArrayLeftBorder) {
                int currentNeedCheckMergeIntervalArrayRightBorder = currentNeedCheckMergeIntervalArray[1];
                    previousCheckedMergeIntervalArray[1]=Math.max(currentNeedCheckMergeIntervalArrayRightBorder, previousCheckedMergeIntervalArrayRightBorder);
            }else {
                mergeIntervalCollect.add(currentNeedCheckMergeIntervalArray);
            }
        }
        return mergeIntervalCollect.toArray(new int[mergeIntervalCollect.size()][]);
    }

    private void intervalArraySort(int[][] needIntervalArray) {
        Arrays.sort(needIntervalArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] previousIntervalArray, int[] currentInterValArray) {
                return previousIntervalArray[0]-currentInterValArray[0];
            }
        });
    }
}
