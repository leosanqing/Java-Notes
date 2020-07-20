package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午4:12
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Write an efficient algorithm that searches for a value in an m x n matrix.
 * `          This matrix has the following properties:
 * `          Integers in each row are sorted in ascending from left to right.
 * `          Integers in each column are sorted in ascending from top to bottom.
 * `      Example:
 * `          Consider the following matrix:
 * `              [
 * `                  [1,   4,  7, 11, 15],
 * `                  [2,   5,  8, 12, 19],
 * `                  [3,   6,  9, 16, 22],
 * `                  [10, 13, 14, 17, 24],
 * `                  [18, 21, 23, 26, 30]
 * `              ]
 * `          Given target = 5, return true.
 * `
 * `          Given target = 20, return false.
 * @Version: 1.0
 */
public class _240_search_a_2D_matrixII {

    public static void main(String[] args) {

        int[][] nums = {
                {1, 5, 7, 9},
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}

    };

        System.out.println(searchMatrix(nums,17));
}

    /**
     * 这个题和 74题 很像。只不过这个下面一行不一定大于上面一行的任何一个数
     * 我们从右上角开始，因为这个是行中最大的，列中最小的
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;

        int num;
        while (row < matrix.length && column >= 0) {
            num = matrix[row][column];
            if (num == target) {
                return true;
            }
            if (num < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}
