package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 下午3:32
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * ` `         Given an array of non-negative integers,
 * ` `         you are initially positioned at the first index of the array.
 * ` `         Each element in the array represents your maximum jump length at that position.
 * ` `         Determine if you are able to reach the last index.
 * ` `
 * ` `         给定一个非负整数数组，
 * ` `         您最初位于数组的第一个索引。
 * ` `         数组中的每个元素代表该位置的最大跳转长度。
 * ` `         确定您是否能够达到最后一个索引。
 * ` `     Example 1:
 * ` `         Input: nums = [2,3,1,1,4]
 * ` `         Output: true
 * ` `         Explanation:
 * ` `             Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * ` `     Example 2:
 * ` `         Input: nums = [3,2,1,0,4]
 * ` `         Output: false
 * ` `         Explanation:
 * ` `             You will always arrive at index 3 no matter what.
 * ` `             Its maximum jump length is 0, which makes it impossible to reach the last index.
 * @Version: 1.0
 */
public class _55_jump_game {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 1, 4}));

        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }


    /**
     * The basic idea is this: at each step, we keep track of the furthest reachable index. The nature of the problem
     * (eg. maximal jumps where you can hit a range of targets instead of singular jumps where you can only hit one
     * target) is that for an index to be reachable, each of the previous indices have to be reachable.
     * <p>
     * Hence, it suffices that we iterate over each index, and If we ever encounter an index that is not reachable,
     * we abort and return false. By the end, we will have iterated to the last index. If the loop finishes, then the
     * last index is reachable.
     * <p>
     * 基本思想是：在每个步骤中，我们都跟踪最远的可到达索引。
     * 问题的性质（例如，您可以击中一个目标范围的最大跳跃，而不是您只能击中一个目标的奇异跳跃）是要使一个索引可以到达，必须使每个先前的索引都可以到达。
     * <p>
     * 因此，我们迭代每个索引就足够了，如果遇到无法访问的索引，我们将中止并返回false。到最后，我们将迭代到最后一个索引。如果循环结束，则最后一个索引可达。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 当 i 大于 reachable 说明这个地方不可达，那肯定有问题
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


}
