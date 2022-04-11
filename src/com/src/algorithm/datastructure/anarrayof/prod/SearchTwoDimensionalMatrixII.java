package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 搜索二维矩阵 二
 * 将二维矩阵搜索二世
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/11
 */
public class SearchTwoDimensionalMatrixII {
    public Boolean mySelf_searchTwoDimensionMatrix(int[][] twoDimensionMatrix, int target) {
        if (twoDimensionMatrix == null||twoDimensionMatrix.length==0) {
            return false;
        }
        int row = twoDimensionMatrix.length;
        int column = twoDimensionMatrix[0].length;

        int currentRow = 0;
        int currentColumn = column - 1;
        while (currentRow<row&&currentColumn>=0) {
            if (twoDimensionMatrix[currentRow][currentColumn]==target) {
                return true;
            }else if (twoDimensionMatrix[currentRow][currentColumn]>target) {
                currentColumn--;
            }else {
                currentRow++;
            }
        }
        return false;
    }
}
