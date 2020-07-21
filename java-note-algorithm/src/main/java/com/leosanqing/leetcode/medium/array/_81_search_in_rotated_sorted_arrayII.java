package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/21 上午11:40
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search.
 * If found in the array return true, otherwise return false.
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * @Version: 1.0
 */
public class _81_search_in_rotated_sorted_arrayII {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }


    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;

        int mid = (end - start) / 2 + start;

        while (start <= end) {
            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            }

            // 说明 mid 没有越过分割点,那么中点左边部分是排好序的
            if (nums[mid] > nums[start]) {
                // 如果 target 比左边点小 或者 比 中点大，那么 我们可以确定这个点 肯定不在 左边
                if (nums[mid] < target || target < nums[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] < nums[start]) {
                // 如果 target 比 中点小 或者 比 最右边的大，那么 target 肯定在 中点左侧
                if (nums[mid] > target || target > nums[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                start++;
            }

            mid = (end - start) / 2 + start;

        }

        return false;
    }


}
