package com.leosanqing.leetcode.medium.string;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @description: `  实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * `
 * ` 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * `
 * ` 必须 原地 修改，只允许使用额外常数空间。
 * `
 * ` 示例 1：
 * `
 * ` 输入：nums = [1,2,3]
 * ` 输出：[1,3,2]
 * ` 示例 2：
 * `
 * ` 输入：nums = [3,2,1]
 * ` 输出：[1,2,3]
 * ` 示例 3：
 * `
 * ` 输入：nums = [1,1,5]
 * ` 输出：[1,5,1]
 * ` 示例 4：
 * `
 * ` 输入：nums = [1]
 * ` 输出：[1]
 * @author: rtliu
 * @date: 2021/4/8 2:07 下午
 */
public class _31_next_permutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1, 3, 2});
    }

    /**
     * 1.从右到左找升序数字
     * 2.找到右边比当前数字大的数字，两个交换位置
     * 3.右边数字再重新升序排列
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                continue;
            }

            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[i - 1] > nums[j]) {
                    continue;
                }

                // 从后面找比 num 大的数字，交换
                int temp = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = temp;

                Arrays.sort(nums, i, nums.length);
                return;

            }

        }
        Arrays.sort(nums);
    }
}
