package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/07
 */
public class PascalsTriangle {

    public List<List<Integer>> mySelf_IterationPascalsTriangle(int pascalsTriangleRows) {
        if (pascalsTriangleRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> pascalsTriangleElementResult = new ArrayList<>();
        for (int triangleNumberOfRows = 0; triangleNumberOfRows < pascalsTriangleRows; ++triangleNumberOfRows) {
            List<Integer> pascalsTriangleRowElementResult = new ArrayList<>();
            for (int triangleNumberOfRowsElementIndex = 0; triangleNumberOfRowsElementIndex <= triangleNumberOfRows; ++triangleNumberOfRowsElementIndex) {
                if (triangleNumberOfRowsElementIndex == 0 || triangleNumberOfRowsElementIndex == triangleNumberOfRows) {
                    pascalsTriangleRowElementResult.add(1);
                } else {
                    pascalsTriangleRowElementResult.add(
                  pascalsTriangleElementResult.get(triangleNumberOfRows - 1).get(triangleNumberOfRowsElementIndex - 1)
                 + pascalsTriangleElementResult.get(triangleNumberOfRows - 1).get(triangleNumberOfRowsElementIndex)
                    );

                }
            }
            pascalsTriangleElementResult.add(pascalsTriangleRowElementResult);


        }
        return pascalsTriangleElementResult;
    }

    /**
     * 我自己第二次迭代帕斯卡三角形
     *
     * @param pascalsTriangleRows 帕斯卡三角行
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> mySelf_SecondIterationPascalsTriangle(int pascalsTriangleRows) {
       List<List<Integer>> pascalsTriangleElementResult = new ArrayList<>();
        for (int pascalsTriangleRow = 0; pascalsTriangleRow < pascalsTriangleRows; pascalsTriangleRow++) {
            List<Integer> pascalsTriangleRowElementResult = new ArrayList<>();
            for (int pascalsTriangleElementResultIndex = 0; pascalsTriangleElementResultIndex <= pascalsTriangleRow; pascalsTriangleElementResultIndex++) {
                if (pascalsTriangleElementResultIndex == 0 || pascalsTriangleElementResultIndex == pascalsTriangleRow) {
                    pascalsTriangleRowElementResult.add(1);
                }else {
                    Integer previousLeft = pascalsTriangleElementResult.get(pascalsTriangleRow - 1).get(pascalsTriangleElementResultIndex - 1);
                    Integer previousRight = pascalsTriangleElementResult.get(pascalsTriangleRow - 1).get(pascalsTriangleElementResultIndex );
                    pascalsTriangleRowElementResult.add(previousLeft + previousRight);
                }
            }
            pascalsTriangleElementResult.add(pascalsTriangleRowElementResult);
        }
        return pascalsTriangleElementResult;
    }
}
