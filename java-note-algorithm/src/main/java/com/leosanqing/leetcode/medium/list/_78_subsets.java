package com.leosanqing.leetcode.medium.list;

import com.alibaba.fastjson.JSON;

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
        System.out.println(JSON.toJSONString(subsets(new int[]{1, 2, 3})));
    }

    /**
     * 这个真的太经典了，回溯的经典题型，你会发现有很多很多这种的题
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            backtrace(answer, new ArrayList<>(), i, nums, 0);
        }

        return answer;
    }

    private static void backtrace(List<List<Integer>> answer, List<Integer> list, int max, int[] nums, int position) {
        if (list.size() == max) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(answer, list, max, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
