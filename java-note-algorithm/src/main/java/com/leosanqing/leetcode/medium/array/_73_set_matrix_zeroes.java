package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 上午11:22
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 *` `         Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 *` `         Do it in-place.
 *` `     Example 1:
 *` `         Input:
 *` `             [
 *` `                 [1,1,1],
 *` `                 [1,0,1],
 *` `                 [1,1,1]
 *` `             ]
 *` `         Output:
 *` `             [
 *` `                 [1,0,1],
 *` `                 [0,0,0],
 *` `                 [1,0,1]
 *` `             ]
 *` `     Example 2:
 *` `         Input:
 *` `             [
 *` `                 [0,1,2,0],
 *` `                 [3,4,5,2],
 *` `                 [1,3,1,5]
 *` `             ]
 *` `         Output:
 *` `             [
 *` `                 [0,0,0,0],
 *` `                 [0,4,5,0],
 *` `                 [0,3,1,0]
 *` `             ]
 * @Version: 1.0
 */
public class _73_set_matrix_zeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        boolean row[] = new boolean[matrix.length];
        boolean column[] = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i]){
                    matrix[i][j] = 0;
                }
                if(column[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }


}
