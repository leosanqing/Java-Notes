package com.leosanqing.leetcode.medium.array;

import java.util.Arrays;

/**
 * @Author: rtliu
 * @Date: 2020/7/6 上午10:51
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: `         Given an array nums of n integers and an integer target,
 * `         find three integers in nums such that the sum is closest to target.
 * `         Return the sum of the three integers.
 * `         You may assume that each input would have exactly one solution.
 * `     Example 1:
 * `         Input:
 * `             nums = [-1,2,1,-4], target = 1
 * `         Output: 2
 * `         Explanation:
 * `             The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @Version: 1.0
 */
public class _16_3num_closest {
    public static void main(String[] args) {

        int[] ints = {
                1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(ints,82));
    }

    /**
     * 时间复杂度O(n²)
     * 设置两个游标，然后进行遍历
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        int sum;
        // 先对大小进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            // start 可以跳过之前的。因为之前的已经比较过
            int start = i+1, end = nums.length - 1;

            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];

                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}
