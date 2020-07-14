package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 上午10:08
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `        Given a collection of numbers that might contain duplicates,
 * `        return all possible unique permutations.
 * `    Example:
 * `        Input: [1,1,2]
 * `        Output: [   [1,1,2],   [1,2,1],   [2,1,1] ]
 * @Version: 1.0
 */
public class _47_permutationsII {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 3}));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return answer;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backTrace(answer, new ArrayList<>(), nums, used);
        return answer;

    }

    /**
     * 递归遍历
     *
     * @param answer
     * @param list
     * @param nums
     */
    private static void backTrace(List<List<Integer>> answer, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果有这个数字，就跳过. 并且排除 相邻相同的数字两种情况。之前的排序就为了这个
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backTrace(answer, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;

        }


    }
}
