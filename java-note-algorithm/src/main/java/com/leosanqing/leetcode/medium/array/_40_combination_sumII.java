package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/13 下午4:04
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1`        Given a collection of candidate numbers (candidates) and a target number (target),
 * 1`        find all unique combinations in candidates where the candidate numbers sums to target.
 * 1`        Each number in candidates may only be used once in the combination.
 * 1`    Note:
 * 1`        All numbers (including target) will be positive integers.
 * 1`        The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * `       给定一组候选编号（候选）和目标编号（target），
 * `       查找候选编号总和为目标的候选中的所有唯一组合。
 * `       组合中的每个候选号码只能使用一次。
 * `    注：
 * `       所有数字（包括目标）将为正整数。
 * `       解决方案集不得包含重复的组合。
 * <p>
 * 1`    Example 1:
 * 1`        Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * 1`        A solution set is: [   [1, 7],   [1, 2, 5],   [2, 6],   [1, 1, 6] ]
 * 1`    Example 2:
 * 1`        Input: candidates = [2,5,2,1,2], target = 5,
 * 1`        A solution set is: [   [1,2,2],   [5] ]
 * @Version: 1.0
 */

public class _40_combination_sumII {

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(nums, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> answer = new ArrayList<>();

        backTrace(answer, new ArrayList<>(), candidates, target, 0);
        return answer;
    }

    private static void backTrace(List<List<Integer>> answer, List<Integer> list, int[] candidates, int remain,
                                  int position) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = position; i < candidates.length; i++) {
            // 去除重复 如 [1,1,2,3]. 去掉第2个1 的结果
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrace(answer, list, candidates, remain - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
