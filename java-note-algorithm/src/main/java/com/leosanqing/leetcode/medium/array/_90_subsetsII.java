package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/22 下午3:00
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given a collection of integers that might contain duplicates, nums, return all possible subsets (the
 * power set).
 * `          Note: The solution set must not contain duplicate subsets.
 * `          Example:
 * `              Input: [1,2,2]
 * `              Output: [   [2],   [1],   [1,2,2],   [2,2],   [1,2],   [] ]
 * @Version: 1.0
 */
public class _90_subsetsII {

    public static void main(String[] args) {
        subsetsWithDup(new int[]{1, 2, 2});
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> answer = new ArrayList<>();

        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backTrace(answer, new ArrayList<>(), nums, 0, i);
        }

        return answer;
    }

    private static void backTrace(List<List<Integer>> answer, List<Integer> list, int[] nums, int position, int max) {

        if (list.size() == max) {

            answer.add(new ArrayList<>(list));

//            if(!answer.contains(new ArrayList<>(list))){
//            }

            return;
        }

        for (int i = position; i < nums.length; i++) {
            if (i > position && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backTrace(answer, list, nums, i + 1, max);
            list.remove(list.size() - 1);
        }

    }


}
