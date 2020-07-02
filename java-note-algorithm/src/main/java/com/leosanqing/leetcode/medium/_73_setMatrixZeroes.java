package com.leosanqing.leetcode.medium;

/**
 * 题目： 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例：输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 思路： 把矩阵的第一行和第一列作为标志位，如果该行或者该列有0，那么他就置为0
 * 然后再遍历，替换
 */
class _73_setMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int col0 = 1, rows = matrix.length, cols = matrix[0].length;


        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        // 遍历集合，把他们变成0
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }


}