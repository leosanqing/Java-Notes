package com.leosanqing.leetcode.easy;

/**
 * @Author: leosanqing
 * @Date: 2020/4/15 上午11:19
 * @Package: easy
 * @Description: 统计素数个数
 * @Version: 1.0
 * <p>
 * <p>
 * 204. Count Primes
 * Des:
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class _204_countPrimes {
    public static void main(String[] args) {
//        System.out.println(new _204_countPrimes().countPrimes(499979));
        int num = 49997;
        System.out.println((new _204_countPrimes().countPrimes(num)) == new _204_countPrimes().countPrimesFast(num));
//        System.out.println(new _204_countPrimes().countPrimesFast(499979));
    }
//

    /**
     * 效率太低 O(n²)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        if (n == 3) {
            return 1;
        }

        boolean flag = false;
        int num = 2;
        for (int i = 3; i < n; i++) {
            flag = false;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == i / 2) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                num++;
            }

        }
        return num;
    }

    /**
     * O(n·log(log(n)))
     * 我们设置一个 bool 型的 数组，长度为 我们要输入的长度
     * 从
     *
     * @param n
     * @return
     */
    public int countPrimesFast(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }
}
