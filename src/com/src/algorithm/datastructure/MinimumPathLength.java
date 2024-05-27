package com.src.algorithm.datastructure;

public class MinimumPathLength {

    public int MinimumPathLength(int[][] map) {

        int row = map.length;
        int column = map[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = map[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[row - 1][column - 1];

    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        MinimumPathLength minimumPathLength = new MinimumPathLength();
        System.out.println(minimumPathLength.MinimumPathLength(map));
    }
}
