package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 旋转矩阵
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/11
 */
public class RotationMatrix {

    public static final double HALF_OF_MATRIX_LENGTH = 2;

    /**
     * 我自己的旋转矩阵
     *
     * @param matrix 矩阵
     */

    public void myself_rotateMatrix(int[][] matrix) {
        int matrixLength = matrix.length;
        for (int matrixRow = 0; matrixRow <=matrixLength/ HALF_OF_MATRIX_LENGTH; matrixRow++) {
            for (int matrixColumn = matrixRow; matrixColumn <=(matrixLength - matrixRow - 2); matrixColumn++) {
            int leftTop = matrix[matrixRow][matrixColumn];
            int rightTop = matrix[matrixColumn][matrixLength - matrixRow - 1];
            int rightBottom = matrix[matrixLength - matrixRow - 1][matrixLength - matrixColumn - 1];
            int leftBottom = matrix[matrixLength - matrixColumn - 1][matrixLength-(matrixLength - matrixRow - 1)-1];
            matrix[matrixRow][matrixColumn] = leftBottom;
            matrix[matrixColumn][matrixLength - matrixRow - 1] = leftTop;
            matrix[matrixLength - matrixRow - 1][matrixLength - matrixColumn - 1] = rightTop;
            matrix[matrixLength - matrixColumn - 1][matrixLength-(matrixLength - matrixRow - 1)-1] = rightBottom;
            }
        }
    }
}
