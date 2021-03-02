package com.leosanqing.leetcode.easy.array;

/**
 * ` 题目：  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * `        你可以假设数组中无重复元素。
 * `
 * ` 举例：  输入: [1,3,5,6], 5
 * `        输出: 2
 * `
 * `        输入: [1,3,5,6], 2
 * `        输出: 1
 * `
 * `
 * ` 思路：  因为题目已经给定了排好的数组，我最直接就想到用二分法
 * `        如果找到了就返回下标，
 * `        没找到就返回左边的下标，
 * `        如果你返回的是right，那你就会有 bug，
 * `
 */

public class _35_searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        _35_searchInsertPosition a35searchInsertPosition = new _35_searchInsertPosition();
        System.out.println(a35searchInsertPosition.searchInsert(a, 4));

    }
}
