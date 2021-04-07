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
public class _11_container_with_most_water {

    /**
     * 这个很简单，也是很经典的问题
     * 设置两个游标，然后比较两个游标上的容器壁的高度，盛水以矮的为主
     * 然后移动游标，那边矮就移动哪边
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left != right) {
            if (height[left] > height[right]) {
                max = Math.max(height[right] * (right - left), max);
                right--;
            } else {
                max = Math.max(height[left] * (right - left), max);
                left++;
            }
        }
        return max;
    }


}
