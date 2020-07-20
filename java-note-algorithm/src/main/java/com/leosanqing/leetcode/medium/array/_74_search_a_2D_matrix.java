package com.leosanqing.leetcode.medium.array;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午2:40
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Write an efficient algorithm that searches for a value in an m x n matrix.
 * `          This matrix has the following properties:
 * `          Integers in each row are sorted from left to right.
 * `          The first integer of each row is greater than the last integer of the previous row.
 * `
 * `          编写一种有效的算法，在m x n矩阵中搜索值。
 * `          该矩阵具有以下属性：
 * `          每行中的整数从左到右排序。
 * `          每行的第一个整数大于前一行的最后一个整数。
 * `      Example 1:
 * `          Input: matrix =
 * `              [
 * `                  [1,   3,  5,  7],
 * `                  [10, 11, 16, 20],
 * `                  [23, 30, 34, 50]
 * `              ]
 * `             target = 3
 * `          Output: true
 * `      Example 2:
 * `          Input:
 * `              matrix = [
 * `                  [1,   3,  5,  7],
 * `                  [10, 11, 16, 20],
 * `                  [23, 30, 34, 50]
 * `                 ] target = 13
 * `         Output: false
 * @Version: 1.0
 */
public class _74_search_a_2D_matrix {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 3, 5, 7},
                {10, 11, 16, 21},
                {22, 25, 27, 30},
                {35, 44, 56, 70}
        };

        int[][] nums = {{1,3}};
        System.out.println(searchMatrix(nums,2));

        System.out.println(searchMatrix(ints, 1));
        System.out.println(searchMatrix(ints, 16));
        System.out.println(searchMatrix(ints, 27));
        System.out.println(searchMatrix(ints, 44));

    }

    /**
     * 把它不当成矩阵,当成一个排好序的列表
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }

        int start = 0;
        int end = m * n - 1;
        int mid = (end - start) / 2 + start;
        int num = Integer.MIN_VALUE;
        while (start <= end) {
            num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            }

            if (num < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (end - start) / 2 + start;
        }

        return false;
    }
}
