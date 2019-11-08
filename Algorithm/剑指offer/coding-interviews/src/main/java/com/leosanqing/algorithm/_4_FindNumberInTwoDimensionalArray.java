package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-08 20:23
 * <p>
 * <p>
 * 题目： 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 例如：如果在下面这个二维数组中查找 7，则返回 true,查找5，则返回false
 * <p>
 * 1    2   8   9
 * 2    4   9   12
 * 4    7   10  13
 * 6    8   11  15
 */


public class _4_FindNumberInTwoDimensionalArray {

    public static void main(String[] args) {

        int[][] nums ={
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(method2(nums,7));
        System.out.println(method2(nums,5));
    }


    /**
     * 拿到这个题目，最简单的就是遍历整个二维数组，这种是最暴力的。
     * 虽然解决了，但是跟没解决一样。时间复杂度为O(n²)
     * <p>
     * 稍微好一点的是，按行遍历，但是遍历的时候，每一行使用二分法。
     * 这样时间复杂度就是 O(nlogn)。
     * <p>
     * 这两种实现方式太简单，就不写了。
     *
     * @return
     */
    public static boolean method1(int[][] nums) {

        return false;
    }

    /**
     * 上面的第二种方法，只利用了题目中的一个条件，每列递增。
     * 但是没有用到每行递增。每行可不能用二分法来简化。
     * 因为你不能保证下面一行的每一个数字一定大于上一行的每一行数字
     *
     *
     * 我们找右上角的数字 x
     *
     * 这个数字比较特殊，一定比该行其他数字大，一定比该列其他数字小
     * 如果x目标值大,(后面目标值 简称y)，那么说明这一列的其他数字不用看了，一定比y大，所以列减1
     * 如果比y小，那么这一行的其他数一定也比y小，所以行+1
     *
     * 这样我们每一次操作总是排除一整行或一整列
     *
     * @param nums 要找的数
     * @return true ,包含该值，否则，不包含
     */
    private static boolean method2(int[][] nums, int num) {

        if (nums == null || nums.length <= 0) {
            return false;
        }
        int column = nums[0].length-1;
        int row = 0;
        while (row <= nums.length - 1 && column >= 0) {
            if(nums[row][column] == num){
                return true;
            }
            else if (nums[row][column] > num) {
                --column;
            } else{
                ++row;
            }
        }
        return false;
    }
}
