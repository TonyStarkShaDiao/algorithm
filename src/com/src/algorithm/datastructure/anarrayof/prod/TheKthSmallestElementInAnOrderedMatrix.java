package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 有序矩阵中第k个最小元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/18
 * 乘法表中第k小的数
 */
public class TheKthSmallestElementInAnOrderedMatrix {
    public int mySelf_binarySearchTheKthSmallestElementInAnOrderedMatrix(int[][] twoDimensionalMatrixArray, int theSmallestNumberOfK) {
        int twoDimensionalMatrixArrayLength = twoDimensionalMatrixArray.length;
        int headerPoint = twoDimensionalMatrixArray[0][0];
        int tailPoint = twoDimensionalMatrixArray[twoDimensionalMatrixArrayLength - 1][twoDimensionalMatrixArrayLength - 1];
        while (headerPoint < tailPoint) {
            int middlePoint = headerPoint + (tailPoint - headerPoint >> 1);
            if (this.checkWhetherTheNumberOfCenterPointersIsEqualToK(twoDimensionalMatrixArray, theSmallestNumberOfK, middlePoint)) {
                tailPoint = middlePoint;
            } else {
                headerPoint = middlePoint + 1;
            }
        }
        return headerPoint;
    }

    /**
     * 检查最后一个位置到中心指针的下标数量是否等于tok
     *
     * @param twoDimensionalMatrixArray 二维矩阵阵列
     * @param theSmallestNumberOfK      k最小数
     * @param middlePoint               中间点
     * @return boolean
     */
    private boolean checkWhetherTheNumberOfCenterPointersIsEqualToK(int[][] twoDimensionalMatrixArray, int theSmallestNumberOfK, int middlePoint) {
        int twoDimensionalMatrixArrayRows = twoDimensionalMatrixArray.length - 1;
        int currentRowsIndex = 0;
        int totalIndexNumber = 0;
        while (twoDimensionalMatrixArrayRows >= 0 && currentRowsIndex < twoDimensionalMatrixArray.length) {
            if (twoDimensionalMatrixArray[twoDimensionalMatrixArrayRows][currentRowsIndex] <= middlePoint) {
                currentRowsIndex++;
                totalIndexNumber = totalIndexNumber + twoDimensionalMatrixArrayRows + 1;
            } else {
                twoDimensionalMatrixArrayRows--;
            }
        }
        return totalIndexNumber >= theSmallestNumberOfK;
    }
}
