package com.leosanqing.leetcode.easy.array;

/**
 * @description: 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: rtliu
 * @date: 2021/4/9 10:09 上午
 */
public class _53_maximum_subarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{2}));
        System.out.println(maxSubArray(new int[]{-1, 2, -1}));
        System.out.println(maxSubArray(new int[]{-1, -1, -2, -2}));
    }

    /**
     * 这个题思路很简单，从左到右遍历，如果前面的和小于当前数，则舍弃之前的数组，从当前位置重新开始找
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num,num);
            max = Math.max(sum, max);
        }
        return max;
    }
}
