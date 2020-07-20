package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 上午10:12
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * `          The robot can only move either down or right at any point in time.
 * `          The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * `          Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * `          An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * `
 * `          Note: m and n will be at most 100.
 * `      Example 1:
 * `          Input:
 * `              [
 * `                  [0,0,0],
 * `                  [0,1,0],
 * `                  [0,0,0]
 * `              ]
 * `          Output: 2
 * `          Explanation:
 * `          There is one obstacle in the middle of the 3x3 grid above.
 * `          There are two ways to reach the bottom-right corner:
 * `              1. Right -> Right -> Down -> Down
 * `              2. Down -> Down -> Right -> Right
 * @Version: 1.0
 */
public class _63_unique_pathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0,}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * 思路和 62题 很像，只不过做些特殊处理
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        int[] pre = new int[columns];
        int[] cur = new int[columns];
        // 先设置第一行
        for (int i = 0; i < columns; i++) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }

            if (obstacleGrid[0][i] == 1) {
                break;
            }
            pre[i] = 1;
            cur[i] = 1;
        }

        // 处理第二行之后的
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 处理 障碍物
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                    continue;
                }
                if (j != 0) {
                    cur[j] = cur[j - 1] + pre[j];
                }
            }

            pre = cur;
        }

        return cur[columns - 1];
    }
}
