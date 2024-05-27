package com.src.algorithm.datastructure.strings.prod;

/**
 * 二分查找
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/19
 */
public class BinarySearch {
    public int mySelf_leftOpenRightOpenBinarySearch(int[] OrderlyArray, int target) {
        int headerPoint = -1;
        int tailPoint = OrderlyArray.length;
        if (headerPoint + 1 != tailPoint) {
            int middlePoint = headerPoint + ((tailPoint - headerPoint) >> 1);
            if (OrderlyArray[middlePoint] >= target) {
                headerPoint = middlePoint;
            } else {
                tailPoint = middlePoint;
            }
        }
        if (headerPoint == -1) {
            return -1;
        }
        return OrderlyArray[headerPoint] == target ? headerPoint : -1;

    }
    //


}
