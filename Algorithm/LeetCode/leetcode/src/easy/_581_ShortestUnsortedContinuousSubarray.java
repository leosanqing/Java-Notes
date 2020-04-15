package easy;

import java.util.Arrays;

/**
 * 题目：      给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * <p>
 * 示例：      输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * <p>
 * 思路：      我们先将其排好序，然后用两个游标，left，right
 * 如果出现了 数字不相等的情况，那么就说明他是我们要找的数，并且left要最小
 * 与之相对，找到right的位置，相减+1就是我们要的长度
 */
class _581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsClone = nums.clone();
        Arrays.sort(nums);
        int left = nums.length - 1, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numsClone[i] != nums[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right - left > 0 ? right - left + 1 : 0;

    }


    public static void main(String[] args) {
        Object object = new Object();

    }
}