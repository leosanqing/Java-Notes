package com.leosanqing.leetcode.medium.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午8:08
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given a set of distinct integers, nums, return all possible subsets (the power set).
 * `          Note: The solution set must not contain duplicate subsets.
 * `      Example:
 * `          Input: nums = [1,2,3]
 * `          Output: [   [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 * @Version: 1.0
 */
public class _78_subsets {
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        if (nums.length == 0) {
            return answer;
        }
        for (int i = 1; i <= nums.length; i++) {
            backTrace(answer, new ArrayList<>(), nums, i, 0);
        }

        return answer;

    }

    /**
     * 这个我已经不想说了，太多一样的解法了
     * @param answer
     * @param list
     * @param nums
     * @param max
     * @param position
     */
    private static void backTrace(List<List<Integer>> answer, List<Integer> list, int[] nums, int max, int position) {
        if (list.size() == max) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);

            backTrace(answer, list, nums, max, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
