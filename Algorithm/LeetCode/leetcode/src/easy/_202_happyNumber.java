package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: leosanqing
 * @Date: 2020/4/15 上午10:17
 * @Package: easy
 * @Description: leetCode 202题
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of
 * its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @Version: v1
 *
 *
 * 思路：
 *      我们看到最后，其实可以猜出来，只有最终变成一位数才有可能达到他的预期，
 *      如果有两位数或者以上，我们肯定是要对他再一次进行运算的，所以我们就一直往下拆数字就行，
 *      但是这里还有个坑，我们怎么让他不会陷入死循环呢？我们要判断他之前是否运算过，因为如果运算过，就会陷入死循环
 *      我们使用 HashSet ，来判断，如果有值，那么这个肯定之前就运算过，就会陷入死循环。不可能是我们想要的 HappyNum
 *
 */
public class _202_happyNumber {
    public static void main(String[] args) {

        _202_happyNumber happyNumber = new _202_happyNumber();
        for (int i = 0; i < 10000; i++) {
            happyNumber.isHappy(i);
        }
    }

    public boolean isHappy(int n) {
        int row = n;
        Set<Integer> set = new HashSet<>();

        while (n > 1) {

            int m = 0;
            //  计算每位的平方的和
            while (n > 0) {
                m = m + (n % 10) * (n % 10);
                n /= 10;
            }
            // 之前运算过，不可能是HappyNum，不跳出去就会陷入死循环
            if (set.contains(m)) {
                return false;
            }
            set.add(m);

            n = m;
        }
        System.out.println(row);
        return true;

    }
}
