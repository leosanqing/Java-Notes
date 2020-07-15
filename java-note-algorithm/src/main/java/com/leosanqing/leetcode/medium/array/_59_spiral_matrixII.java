package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/15 下午5:14
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given a positive integer n,
 * `          generate a square matrix filled with elements from 1 to n2 in spiral order.
 * `      Example:
 * `          Input: 3
 * `          Output:
 * `              [
 * `                  [ 1, 2, 3 ],
 * `                  [ 8, 9, 4 ],
 * `                  [ 7, 6, 5 ]
 * `              ]
 * @Version: 1.0
 */
public class _59_spiral_matrixII {

    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }

    public static int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[][]{};
        }
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        while (count <= n*n) {
            for (int i = left; i <= right; i++, count++) {
                result[top][i] = count;
            }
            top++;

            for (int i = top; i <= bottom; i++, count++) {
                result[i][right] = count;
            }
            right--;

            for (int i = right; i >= left; i--, count++) {
                result[bottom][i] = count;
            }
            bottom--;

            for (int i = bottom; i >= top; i--, count++) {
                result[i][left] = count;
            }
            left++;
        }

        return result;
    }
}
