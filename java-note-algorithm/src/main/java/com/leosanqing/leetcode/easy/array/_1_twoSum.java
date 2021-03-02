package com.leosanqing.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * description:Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 给你一个数组，返回数组两个元素相加等于目标值的元素的下标，返回其中一组解即可。同一个元素不能用两次；
 * <p>
 * 如{1,2,5,6,7,2} 目标值 11
 * 返回{2,3}
 * solution: 利用HashMap存储元素以及下标，遍历元素，利用hash表，直接锁定另外一个符合条件的下标
 */
class _1_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])
                    && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get((target - nums[i]))};
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6};

        twoSum(a, 7);
    }
}