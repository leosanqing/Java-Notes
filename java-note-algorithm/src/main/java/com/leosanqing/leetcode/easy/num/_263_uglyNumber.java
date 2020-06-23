package com.leosanqing.leetcode.easy.num;

/**
 * @Author: rtliu
 * @Date: 2020/6/23 下午3:34
 * @Package: com.leosanqing.leetcode.easy.num
 * @Description: Write a program to check whether a given number is an ugly number.
 *               Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * @Version: 1.0
 */
public class _263_uglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(15));
    }

    public static boolean isUgly(int num) {

        if (num == 0) {
            return false;
        }

        while (num != 1) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
