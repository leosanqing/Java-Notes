package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-17 09:25
 * <p>
 * 题目：请实现一个函数，输入一个整数的时候，输出这个整数的二进制中的1的个数
 * <p>
 * 例如：输入9 的二进制为 1001 ，输入 9 ，输出2
 */
public class _15_Count1InBinaryNum {
    public static void main(String[] args) {
        System.out.println(method1(9));
        System.out.println(method1(Integer.MAX_VALUE));
        System.out.println(method1(Integer.MIN_VALUE));


        System.out.println(method2(9));
        System.out.println(method2(Integer.MAX_VALUE));
        System.out.println(method2(Integer.MIN_VALUE));
    }

    /**
     * 常规解法，将二进制的每一位从右往左与当前位的1进行 与(&)运算
     * <p>
     * 例如 1001 先从最右边的1 和1 进行 &运算。判断他的结果，如果为1，则计数加一
     * 然后 将 0 和 10 进行相与。判断
     * <p>
     * 重复上述操作
     * <p>
     * 因为整数一共有 32 位，所以要循环32次
     *
     * @param num
     * @return
     */
    private static int method1(int num) {
        int count = 0;

        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }

    /**
     * 比较高效的解法
     * <p>
     * 将 num 和 num-1 进行与运算
     * <p>
     * 比如 9 为 1001, 这个时候计数+1，然后 1001 & 1000 进行与运算 就变成 1000。
     * 然后 再用 1000 重复上述操作。 计数+1 ，然后 1000 & 0111
     * 直到 num ==0 。
     * <p>
     * 这样只需要循环 有几个1次
     *
     * @param num
     * @return
     */
    private static int method2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num & num - 1);
        }
        return count;
    }
}
