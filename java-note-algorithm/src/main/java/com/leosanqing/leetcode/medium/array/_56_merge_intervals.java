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
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 先进行排序，这样才能一个个进行合并
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> list = new ArrayList<>();

        int[] newInterval = intervals[0];
        list.add(intervals[0]);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // 让他指向下一个
                newInterval = interval;
                list.add(newInterval);
            }
        }


        return list.toArray(new int[list.size()][]);
    }
}
