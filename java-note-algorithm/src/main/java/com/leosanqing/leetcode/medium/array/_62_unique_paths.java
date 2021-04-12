package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 上午9:47
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * `          The robot can only move either down or right at any point in time.
 * `          The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * `          How many possible unique paths are there?
 * `          Above is a 7 x 3 grid. How many possible unique paths are there?
 * `
 * `          机器人位于m x n网格的左上角（在下图中标记为“开始”）。
 * `          机器人只能在任何时间点上下移动。
 * `          机器人试图到达网格的右下角（在下图中标记为“完成”）。
 * `          有多少可能的唯一路径？
 * `          上面是7 x 3的网格。有多少种可能的独特路径？
 * `      Example 1:
 * `          Input: m = 3, n = 2
 * `          Output: 3
 * `          Explanation:
 * `              From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * `              1. Right -> Right -> Down
 * `              2. Right -> Down -> Right
 * `              3. Down -> Right -> Right
 * `      Example 2:
 * `          Input: m = 7, n = 3
 * `          Output: 28
 * @Version: 1.0
 */
public class _62_unique_paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePaths(3, 7));
    }

    /**
     * 使用动态规划，机器人只能向下或者向右，所以当前到当前坐标的可能性就是 上边坐标的可能性加上左边坐标的可能性
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[] pre = new int[m];
        int[] cur = new int[m];

        for (int i = 0; i < m; i++) {
            cur[i] = 1;
            pre[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur;
        }

        return cur[m - 1];
    }

}
