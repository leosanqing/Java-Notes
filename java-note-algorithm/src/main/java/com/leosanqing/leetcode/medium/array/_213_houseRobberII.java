package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/2 下午2:20
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description:
 *`      You are a professional robber planning to rob houses along a street.
 *`      Each house has a certain amount of money stashed.
 *`      All houses at this place are arranged in a circle.
 *`      That means the first house is the neighbor of the last one.
 *`      Meanwhile, adjacent houses have security system connected
 *`      and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *`      Given a list of non-negative integers representing the amount of money of each house,
 *`      determine the maximum amount of money you can rob tonight without alerting the police.
 *
 *`   Example 1:
 *`      Input: [2,3,2]
 *`      Output: 3
 *`      Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *`      because they are adjacent houses.
 *
 *`   Example 2:
 *`      Input: [1,2,3,1]
 *`      Output: 4 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *`      Total amount you can rob = 1 + 3 = 4.
 * @Version: 1.0
 */
public class _213_houseRobberII {

    public static void main(String[] args) {
        _213_houseRobberII houseRobberII = new _213_houseRobberII();

        System.out.println(houseRobberII.rob(new int[]{1,5,4,1,8,7,5,14,8,4}));
    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob0(nums), rob1(nums));
    }

    public int rob0(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }

    public int rob1(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 1; i < nums.length; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }

}


