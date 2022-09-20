package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 搜索旋转排序数组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/13
 */
public class SearchRotationSortArray {
    public int mySelf_DichotomySearchRotationSortArray(int[] needAnalysisArray, int rotateArrayIndex) {
        int headerPoint = 0, tailPoint = needAnalysisArray.length - 1;
        while (headerPoint <= tailPoint) {
            int middlePoint = headerPoint + (tailPoint - headerPoint) / 2;
            if (needAnalysisArray[middlePoint] == rotateArrayIndex) {
                return middlePoint;
            }
            if (needAnalysisArray[headerPoint] < needAnalysisArray[middlePoint]) {
                if (needAnalysisArray[headerPoint] <= rotateArrayIndex && needAnalysisArray[middlePoint] > rotateArrayIndex) {
                    tailPoint = middlePoint - 1;
                } else {
                    headerPoint = middlePoint + 1;
                }
            } else {
                if (needAnalysisArray[middlePoint] < rotateArrayIndex && needAnalysisArray[tailPoint] >= rotateArrayIndex) {
                    headerPoint = middlePoint + 1;
                } else {
                    tailPoint = middlePoint - 1;
                }

            }
        }
        return headerPoint;
    }
}
