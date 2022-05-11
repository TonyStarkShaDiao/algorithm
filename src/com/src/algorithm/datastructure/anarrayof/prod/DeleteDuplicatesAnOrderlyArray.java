package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 删除重复有序数组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2021/12/30
 */
public class DeleteDuplicatesAnOrderlyArray {

    public int mySelf_doublePoint(int[] needWeightRemovalArray) {
        if (needWeightRemovalArray == null || needWeightRemovalArray.length < 2) {
            return 0;
        }
        int fastPoint = 1;
        int slowPoint = 0;
        while (fastPoint < needWeightRemovalArray.length) {
            if (needWeightRemovalArray[fastPoint] != needWeightRemovalArray[slowPoint]) {
                needWeightRemovalArray[slowPoint + 1] = needWeightRemovalArray[fastPoint];
                slowPoint++;
            }
            fastPoint++;
        }
        return slowPoint + 1;
    }

}
