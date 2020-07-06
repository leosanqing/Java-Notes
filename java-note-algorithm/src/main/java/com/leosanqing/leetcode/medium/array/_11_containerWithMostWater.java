package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/3 下午4:44
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: `    Given n non-negative integers a1, a2, ..., an ,
 * `    where each represents a point at coordinate (i, ai).
 * `    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * `    Find two lines, which together with x-axis forms a container,
 * `    such that the container contains the most water.
 * <p>
 * <p>
 * `    Note: You may not slant the container and n is at least 2.
 * `    The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * `    In this case, the max area of water (blue section) the container can contain is 49.
 * `
 * ` Example:
 * <p>
 * `    Input: [1,8,6,2,5,4,8,3,7]
 * `    Output: 49
 * @Version: 1.0
 */
public class _11_containerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {

            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i++]);

            } else {
                max = Math.max(max, (j - i) * height[j--]);
            }
        }
        return max;
    }
}
