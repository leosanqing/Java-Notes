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
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            } else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            } else if (nums[i] == 2) {
                nums[++n2] = 2;
            }

        }
    }


    /**
     * 使用两个指针，p1指向0，p2指向2
     * 然后遍历，找到0就和 P1上的数字交换，找到2就和p2上的数字交换
     *
     * 但是这个时候有一个情况是，2交换后仍可能是2
     * 参考 0 2 1 2 1 0 2 自己手动交换一下就知道，所以才有 while里面的内容
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int n1 = 0;
        int n2 = nums.length - 1;

        for (int i = 0; i <= n2; i++) {
            // 交换过后 此时 nums[i] 可能是 0，也可能是2 ，还需要再继续交换
            while (i <= n2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[n2];
                nums[n2] = temp;
                --n2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[n1];
                nums[n1] = temp;
                ++n1;
            }
        }
    }
}
