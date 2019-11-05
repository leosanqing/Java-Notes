import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: leosanqing
 * @Date: 2019-11-05 22:16
 */

/**
 * 面试题3，数组中重复的数字
 * <p>
 * 首先，审题很重要！ 题目中有一个关键的信息
 * 这个数组中的数字是 0~n-1,说明没有负数，而且大小不超过 n-1。
 * <p>
 * 我们就可以规定， 没找到重复的数字就返回 -1，找到了就直接返回
 */
public class _3_FindRepeatNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 5, 4, 2, 3, 1, 6};
        System.out.println(method1(numbers));
        System.out.println(method2(numbers));
        System.out.println(method3(numbers));
    }

    /**
     * 最简单也是最容易想到的，排序，然后遍历数组
     * 这样子时间复杂度 O(nlogn+n)，空间复杂度O(n)
     *
     * @param numbers
     * @return -1表示没找到，非负数表示找到的重复的数
     */
    private static int method1(int[] numbers) {
        // 因为这些情况不可能会出现重复的数字
        if (numbers == null || numbers.length <= 1) {
            return -1;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return numbers[i];
            }
        }
        // -1表示没有找到重复的数字
        return -1;
    }


    /**
     * 使用HashMap来找
     * 时间复杂度 为 O(n)，空间复杂度O(n)
     *
     * @param numbers
     * @return -1表示没找到，非负数表示找到的重复的数
     */
    private static int method2(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return -1;
        }
        HashMap<Integer, String> map = new HashMap<Integer, String>(numbers.length);
        for (int number : numbers) {
            if (map.containsKey(number)) {
                return number;
            }
            map.put(number, "");
        }
        return -1;
    }

    /**
     * 这种方法是利用题目的条件，因为题目说数字一定在 0~n-1，所以不会超出数组范围
     * 我们查看当前 数组下标和数组的那个数(称为x)是否相等，不相等则与该数组下标为x的数进行交换
     * 然后再判断 x的下标与 x是否相等，不相等重复上述操作，相等则下标+1
     * 直到找到数字
     *
     * @param numbers
     * @return -1表示没找到，非负数表示找到的重复的数
     */
    private static int method3(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return -1;
        }

        for (int i = 0; i < numbers.length; i++) {

            // 如果下标和数组上的数字不一样，交换
            while (numbers[i] != i) {
                // 找到了 就直接返回
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 没找到就一直交换
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }

        }
        return -1;
    }
}
