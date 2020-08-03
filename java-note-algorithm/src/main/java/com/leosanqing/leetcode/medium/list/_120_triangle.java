package com.leosanqing.leetcode.medium.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 上午9:29
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given a triangle, find the minimum path sum from top to bottom.
 * `          Each step you may move to adjacent numbers on the row below.
 * `          For example, given the following triangle
 * `
 * `          给定一个三角形，找到从上到下的最小路径总和。
 * `          您可以将每一步移至下面一行中的相邻数字。
 * `          例如，给定以下三角形
 * `          [
 * `                  [2],
 * `                 [3,4],
 * `                [6,5,7],
 * `               [4,1,8,3]
 * `          ]
 * `          The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @Version: 1.0
 */
public class _120_triangle {
    public static void main(String[] args) {
        int[][] list = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(lists));
    }

    /**
     * 动态规划
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {

        int[] ints = new int[triangle.size()];
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : triangle) {
            // 从右到左，如果从左到右，ints[n-1]会被之前的修改覆盖
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    ints[0] += list.get(0);
                } else if (j == list.size() - 1) {
                    ints[j] = list.get(j) + ints[j - 1];
                } else {
                    ints[j] = list.get(j) + Math.min(ints[j - 1], ints[j]);
                }
            }
        }
        for (int anInt : ints) {
            if (min > anInt) {
                min = anInt;
            }
        }

        return min;

    }


}
