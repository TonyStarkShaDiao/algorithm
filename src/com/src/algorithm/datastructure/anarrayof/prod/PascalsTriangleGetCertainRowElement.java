package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/07
 */
public class PascalsTriangleGetCertainRowElement {

    /**
     * 帕斯卡三角得到某些行元素
     *
     * @param pascalsTriangleRowIndex 帕斯卡三角行索引
     * @return {@code List<Integer>}
     */
    public List<Integer> Myself_pascalsTriangleGetCertainRowElement(int pascalsTriangleRowIndex) {
        List<Integer> pascalsTriangleElementCollect = new ArrayList<>();
        for (int currentPascalsTriangleRowIndex = 0; currentPascalsTriangleRowIndex <= pascalsTriangleRowIndex; currentPascalsTriangleRowIndex++) {
            List<Integer> temporaryPascalsTriangleElementCollect = new ArrayList<>();
            for (int currentPascalsTriangleRowElementIndex = 0; currentPascalsTriangleRowElementIndex <= currentPascalsTriangleRowIndex; currentPascalsTriangleRowElementIndex++) {
                if (currentPascalsTriangleRowElementIndex == 0 || currentPascalsTriangleRowElementIndex == currentPascalsTriangleRowIndex) {
                    temporaryPascalsTriangleElementCollect.add(1);
                } else {
                    Integer previousLeft = pascalsTriangleElementCollect.get(currentPascalsTriangleRowElementIndex - 1);
                    Integer previousRight = pascalsTriangleElementCollect.get(currentPascalsTriangleRowElementIndex);
                    temporaryPascalsTriangleElementCollect.add(previousLeft + previousRight);
                }
            }
            pascalsTriangleElementCollect = temporaryPascalsTriangleElementCollect;
        }
        return pascalsTriangleElementCollect;
    }

    public List<Integer> Myself_ReversePascalsTriangleGetCertainRowElement(int pascalsTriangleRowIndex) {
        List<Integer> paiTriangleElementCollect = new ArrayList<>();
        paiTriangleElementCollect.add(1);
        for (int currentPascalsTriangleRowIndex = 1; currentPascalsTriangleRowIndex <= pascalsTriangleRowIndex; currentPascalsTriangleRowIndex++) {
            paiTriangleElementCollect.add(0);
            for (int currentPascalsTriangleRowElementIndex = currentPascalsTriangleRowIndex; currentPascalsTriangleRowElementIndex > 0; currentPascalsTriangleRowElementIndex--) {
                paiTriangleElementCollect.set(currentPascalsTriangleRowElementIndex, paiTriangleElementCollect.get(currentPascalsTriangleRowElementIndex - 1) + paiTriangleElementCollect.get(currentPascalsTriangleRowElementIndex));
            }
        }
        return paiTriangleElementCollect;
    }

//[1]
//[1, 0]
//[1, 1]
//[1, 1, 0]
//[1, 1, 1]
//[1, 2, 1]
//[1, 2, 1, 0]
//[1, 2, 1, 1]
//[1, 2, 3, 1]
//[1, 3, 3, 1]
//[1, 3, 3, 1, 0]
//[1, 3, 3, 1, 1]
//[1, 3, 3, 4, 1]
// [1, 3, 6, 4, 1]
// [1, 4, 6, 4, 1]
}
