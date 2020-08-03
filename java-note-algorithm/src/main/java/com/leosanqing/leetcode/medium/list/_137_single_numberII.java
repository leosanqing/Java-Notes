package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 下午5:29
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 *`          Given a non-empty array of integers,
 *`          every element appears three times except for one,
 *`          which appears exactly once. Find that single one.
 *`          Note:  Your algorithm should have a linear runtime complexity.
 *`          Could you implement it without using extra memory?
 *`      Example 1:
 *`          Input: [2,2,3,2]
 *`          Output: 3
 *`      Example 2:
 *`          Input: [0,1,0,1,0,1,99]
 *`          Output: 99
 *`
 * @Version: 1.0
 */
public class _137_single_numberII {
    public static void main(String[] args) {
        int[] ints = {2,2,3,2};
        System.out.println(singleNumber(ints));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

}
