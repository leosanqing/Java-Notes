package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 下午4:23
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given a collection of intervals, merge all overlapping intervals.
 * `      Example 1:
 * `          Input: [[1,3],[2,6],[8,10],[15,18]]
 * `          Output: [[1,6],[8,10],[15,18]]
 * `          Explanation:
 * `              Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * `      Example 2:
 * `          Input: [[1,4],[4,5]]
 * `          Output: [[1,5]]
 * `          Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * @Version: 1.0
 */
public class _56_merge_intervals {
    /**
     * 先对给定的数组进行排列
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> answer = new ArrayList<>();

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if (answer.isEmpty()) {
                answer.add(new int[]{left, right});
                continue;
            }

            if (answer.get(answer.size() - 1)[1] < left) {
                answer.add(new int[]{left, right});
            } else {
                answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], right);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
