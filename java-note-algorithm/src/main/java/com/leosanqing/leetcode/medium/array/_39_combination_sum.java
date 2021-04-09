package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/13 下午2:29
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * <p>
 * 给定一组候选编号（候选）（无重复）和目标编号（target），
 * 在候选人编号总和为目标的候选人中找到所有唯一组合。
 * 可以从候选人无限制的次数中选择相同的重复号码。
 * `      Note:
 * `         All numbers (including target) will be positive integers.
 * `         The solution set must not contain duplicate combinations.
 * `      Example 1:
 * `         Input: candidates = [2,3,6,7], target = 7,
 * `         A solution set is: [   [7],   [2,2,3] ]
 * `      Example 2:
 * `         Input: candidates = [2,3,5], target = 8,
 * `         A solution set is: [   [2,2,2,2],   [2,3,3],   [3,5] ]
 * @Version: 1.0
 */
public class _39_combination_sum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};

        combinationSum(nums, 7);

    }

    /**
     * 这种的做多了，就会发现基本都是一个套路，递归调用
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        // 先排序
        Arrays.sort(candidates);

        backtrace(answer, candidates, target, new ArrayList<>(), 0);

        return answer;
    }

    private static void backtrace(List<List<Integer>> answer, int[] candidates, int target, List<Integer> list, int position) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = position; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrace(answer, candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
