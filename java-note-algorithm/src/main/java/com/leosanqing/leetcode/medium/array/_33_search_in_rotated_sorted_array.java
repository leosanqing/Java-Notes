package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/9 下午1:58
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: `         Suppose an array sorted in ascending order is rotated at some pivot unknown to you
 * beforehand.
 * `         (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * `         You are given a target value to search.
 * `         If found in the array return its index, otherwise return -1.
 * `         You may assume no duplicate exists in the array.
 * `         Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * <p>
 * `        假设以升序排序的数组以您不知道的某个枢轴旋转。
 * `        （即[0,1,2,4,5,6,7]可能会变成[4,5,6,7,0,1,2]）。
 * `        为您提供了要搜索的目标值。
 * `        如果在数组中找到，则返回其索引，否则返回-1。
 * `        您可以假设数组中不存在重复项。
 * `        算法的运行时复杂度必须为O（log n）的数量级。
 * `
 * `     Example 1:
 * `         Input: nums = [4,5,6,7,0,1,2], target = 0
 * `         Output: 4
 * `
 * `     Example 2:
 * `         Input: nums = [4,5,6,7,0,1,2], target = 3
 * `         Output: -1
 * @Version: 1.0
 */
public class _33_search_in_rotated_sorted_array {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search2(nums, 0));
    }

    /**
     * 虽然他不是全部从小到大排序，我们不能用二分法
     * 但是他有两个部分，两个都是从小到大排序
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            // 5,7,8,0,1,2,3,4
            if (nums[left] > nums[mid]) {
                // target = 7
                if (target < nums[mid] || nums[left] <= target) {
                    right = mid - 1;
                } else {
                    // target = 2
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    private static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 说明 mid 和 target 在同一侧
            if ((nums[mid] - nums[nums.length-1]) * (target - nums[nums.length-1]) > 0) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }else if(target - nums[nums.length-1] > 0){
                // target 在左侧
                right = mid;
            }else{
                left = mid+1;
            }
        }
        if(nums[left] == target){
            return left;
        }

        return -1;
    }
}
