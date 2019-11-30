package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-26 20:52
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。不得使用库函数，不需要考虑大数问题
 */
public class _16_NumberPower {
    public static void main(String[] args) throws Exception {


        System.out.println(method1(2, 2));
        System.out.println(method1(10, 2));
        System.out.println(method1(1, 2));
        System.out.println(method1(2, -2));
        System.out.println(method2(2, -2));
        System.out.println(method2(10,-10));

    }


    /**
     * 这个是最容易想到的。
     * <p>
     * 只要一直累乘就能达到效果
     * <p>
     * 不过要考虑 底数和指数都为0的情况，和指数为负数的情况
     *
     * @param base
     * @param exponent
     * @return
     * @throws Exception
     */
    private static double method1(double base, int exponent) throws Exception {

        if (base == 0 && exponent == 0) {
            throw new Exception("输入的参数无效，base和exponent 不能同时为0");
        }

        if (base == 0) {
            return 0;
        }
        if (exponent == 1) {
            return base;
        }

        boolean isPositiveNum = true;
        if (exponent < 0) {
            isPositiveNum = false;
            exponent = -exponent;
        }

        for (int i = 0; i < exponent - 1; i++) {
            base *= base;
        }


        if (!isPositiveNum) {
            return 1 / base;
        }
        return base;

    }


    private static double method2(double base, int exponent) throws Exception {
        if (base == 0 && exponent == 0) {
            throw new Exception("输入的参数无效，base和exponent 不能同时为0");
        }

        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }


        boolean isPositiveNum = true;
        if (exponent < 0) {
            isPositiveNum = false;
            exponent = -exponent;
        }


        //使用递归调用
        // 10 ^ 10 == (10^5 * 10 ^5) == ((10^2*10^2*10) * (10^2*10^2*10))
        double result = method2(base, exponent >>1);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }

        if (!isPositiveNum) {
            return 1 / result;
        }
        return result;
    }
}
