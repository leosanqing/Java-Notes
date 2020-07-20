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

        System.out.println(minPathSum(ints) == minPathSum1(ints));
    }


    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        // 第一层特殊处理，因为他没有上一层
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 最左边的一列，只有上面的路径可以达到
                    dp[j] += grid[i][j];
                } else {
                    // 因为dp数组他更新了，这样子 dp[j-1] 就是  grid[i][j] 左边的路径之和，dp[j] 就是他上面的那个路径之和
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[n - 1];
    }


    private static int minPathSum1(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }

        int[] result = new int[grid[0].length];

        // 第一层 特殊处理
        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                result[0] = grid[0][i];
            } else {
                result[i] = result[i - 1] + grid[0][i - 1];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            // 第一列特殊处理
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    result[0] = grid[i][0] + result[0];
                } else {
                    result[j] = grid[i][j] + Math.min(result[j], result[j - 1]);
                }
            }
        }

        return result[grid[0].length - 1];
    }


}
