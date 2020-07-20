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
        System.out.println(uniquePaths(3,3));
    }

    /**
     * 这个解法和 64题 类似 都是使用 DP
     *
     * @param cols
     * @param rows
     * @return
     */
    public static int uniquePaths(int cols, int rows) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        // 第一行 到达每个节点只有一条道路 所以每个都设置成 1
        for (int i = 0; i < cols; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }

        // 第一列 到达的路径只有从上面走的一种，所以也全是1，可以不用管，上面已经设置过
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 能到达的可能性就是  上边的 + 左边的 可能性
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur;
        }

        return cur[cols - 1];
    }

}
