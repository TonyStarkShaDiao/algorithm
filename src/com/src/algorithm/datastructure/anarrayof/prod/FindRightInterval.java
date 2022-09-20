package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 寻找右区间
 * 在长度 2N 的数组中找出重复 N 次的元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/20
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[][] sectionStartElementAndIndexArray = new int[intervals.length][2];
        for (int intervalsIndex = 0; intervalsIndex < intervals.length; intervalsIndex++) {
            sectionStartElementAndIndexArray[intervalsIndex][0] = intervals[intervalsIndex][0];
            sectionStartElementAndIndexArray[intervalsIndex][1] = intervalsIndex;
        }
        Arrays.sort(sectionStartElementAndIndexArray, Comparator.comparingInt(firstOneStartElement -> firstOneStartElement[0]));
        int[] result = new int[intervals.length];
        for (int intervalsIndex = 0; intervalsIndex < intervals.length; intervalsIndex++) {
            int endElement = intervals[intervalsIndex][1];
            int startElement = sectionStartElementAndIndexArray[0][0];
            if (endElement < startElement || endElement > sectionStartElementAndIndexArray[sectionStartElementAndIndexArray.length - 1][0]) {
                result[intervalsIndex] = -1;
            } else {
                int headerPoint = 0;
                int tailPoint = sectionStartElementAndIndexArray.length - 1;
                while (headerPoint < tailPoint) {
                    int middlePoint = headerPoint + ((tailPoint - headerPoint) >> 1);
                    if (endElement > sectionStartElementAndIndexArray[middlePoint][0]) {
                        headerPoint = middlePoint + 1;
                    } else {
                        tailPoint = middlePoint;
                    }
                }
//                int resultElement=   sectionStartElementAndIndexArray[headerPoint][0]<=endElement?headerPoint-1:-1;
                result[intervalsIndex] = sectionStartElementAndIndexArray[headerPoint][1];
            }
        }
        return result;
    }
}
