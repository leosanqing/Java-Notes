package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/16 下午4:50
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given a m x n grid filled with non-negative numbers,
 * `          find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * `      Note:
 * `          You can only move either down or right at any point in time.
 * `      Example:
 * `          Input:
 * `              [
 * `                  [1,3,1],
 * `                  [1,5,1],
 * `                  [4,2,1]
 * `              ]
 * `          Output: 7
 * `      Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * @Version: 1.0
 */
public class _64_minimum_path_sum {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 3, 1, 1},
                {1, 5, 12, 1},
                {4, 2, 10, 2},
                {1, 1, 1, 10}
        };

        System.out.println(minPathSum(ints));
    }


    private static int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }


}
