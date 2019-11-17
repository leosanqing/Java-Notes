package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-16 23:08
 * <p>
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * <p>
 * 注意上面的 非递减 排序，这个和书中的不太一样。书中的是递增的，
 * 但是后面的第二种情况就是非递减的
 */
public class _11_SpinArray {
    public static void main(String[] args) throws Exception {

        System.out.println(method3(new int[]{3, 4, 5, 1, 2}));
        System.out.println(method3(new int[]{1, 1, 1, 0, 1, 1, 1}));
    }

    /**
     * 第一种 ，最简单的方法，直接遍历，O(n)的时间复杂度
     * 但是这种方法并没有用到题目的旋转条件
     * <p>
     * 我就不实现了，因为太简单了
     *
     * @param nums
     * @return
     */
    private static int method1(int[] nums) {
        return 0;
    }

    /**
     * 这种的有缺陷，只能是递增的
     *
     * @param nums
     * @return
     * @throws Exception
     */
    private static int method2(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            throw new Exception("数组为空");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        int mid = (right - left) >> 1 + left;
        while (left <= right) {
            if (left + 1 == right) {
                mid = right;
                break;
            }
            mid = (right + left) / 2;

            // 左边的向右移
            if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[mid];

    }


    /**
     * 如果旋转的是非递减的序列
     * @param nums
     * @return
     * @throws Exception
     */
    private static int method3(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            throw new Exception("数组为空");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        int mid = (right - left) >> 1 + left;
        while (nums[left] >= nums[right]) {
            if (left + 1 == right) {
                mid = right;
                break;
            }
            mid = (right + left) / 2;

            // 我们在这个区间要挨个比较
            if (nums[left] == nums[right] && nums[mid] == nums[left]) {
                if (nums[left + 1] != nums[right - 1]) {
                    mid = nums[left + 1] > nums[right - 1] ? right - 1 : left + 1;
                    return nums[mid];
                } else {
                    left++;
                    right--;
                }
            } else {
                // 左边的向右移
                if (nums[mid] >= nums[left]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return nums[mid];

    }

}
