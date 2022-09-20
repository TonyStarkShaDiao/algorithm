package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 搜索旋转排序数组ii
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/13
 */
public class SearchRotationSortArrayII {

    public boolean mySelf_binarySearchSearchRotationSortArrayII(int[] needAnalysisArray, int rotateArrayIndex) {
        int headerTail = 0, tail = needAnalysisArray.length - 1;
        while (headerTail <= tail) {
            int midPoint = headerTail + (tail - headerTail) / 2;
            if (needAnalysisArray[midPoint] == rotateArrayIndex) {
                return true;
            }
            while (headerTail <= midPoint && needAnalysisArray[headerTail] == needAnalysisArray[midPoint]) {
                headerTail++;
            }
            if (headerTail > midPoint) {
                headerTail = midPoint + 1;
                continue;
            }
            if (needAnalysisArray[headerTail] < needAnalysisArray[midPoint]) {
                if (needAnalysisArray[headerTail] <= rotateArrayIndex && rotateArrayIndex < needAnalysisArray[midPoint]) {
                    tail = midPoint - 1;
                } else {
                    headerTail = midPoint + 1;
                }
            } else {
                if (needAnalysisArray[tail] >= rotateArrayIndex && rotateArrayIndex >= needAnalysisArray[midPoint]) {
                    headerTail = midPoint + 1;
                } else {
                    tail = midPoint - 1;
                }
            }
        }
        return false;
    }
}
