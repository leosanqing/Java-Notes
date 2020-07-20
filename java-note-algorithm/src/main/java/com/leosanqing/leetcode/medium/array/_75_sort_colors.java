package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午7:21
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given an array with n objects colored red, white or blue,
 * `          sort them in-place so that objects of the same color are adjacent,
 * `          with the colors in the order red, white and blue.
 * `          Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * `          Note: You are not suppose to use the library's sort function for this problem.
 * `      Example:
 * `          Input: [2,0,2,1,1,0]
 * `          Output: [0,0,1,1,2,2]
 * @Version: 1.0
 */
public class _75_sort_colors {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        int n2 = -1, n1 = -1, n0 = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            }else if(nums[i] == 1){
                nums[++n2] = 2;
                nums[++n1] = 1;
            }else if(nums[i] == 2){
                nums[++n2] = 2;
            }

        }
    }
}
