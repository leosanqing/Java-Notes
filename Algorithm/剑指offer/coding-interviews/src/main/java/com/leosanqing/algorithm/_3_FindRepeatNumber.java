package com.leosanqing.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: leosanqing
 * @Date: 2019-11-05 22:16
 */

/**
 * 面试题3，题目一：数组中重复的数字
 * <p>
 * 在一个长度为n的数组中，所有的数字都在 0~n-1的范围内，数组中某些数字是重复的
 * 但不知道哪些数字重复了，也不知道那个数字重复了几次。请找出数组中任意重复的数字
 * 例如：如果数组为长度为7的{2，3，1，0，2，5，3}。
 * 那么对应的输出是重复的数字2或者3
 * <p>
 * <p>
 * 首先，审题很重要！ 题目中有几个关键的信息
 * 1.这个数组中的数字是 0~n-1,说明没有负数，而且大小不超过 n-1。
 * 我们就可以规定， 没找到重复的数字就返回 -1，找到了就直接返回
 * 2.只需要找出其中一个就算完成题目
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
     * <p>
     * 时间复杂度O(n)，空间复杂度O(1)
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

/**
 * 题目二：不修改数组找出重复的数
 * <p>
 * 这个题目和上一个类似，不过多了几个限定的条件，1.数组中的数字至少有一个重复。2.不可以修改数组
 * <p>
 * 题目：在一个长度为n+1的数组中所有的数字都在 1~n+1，所以 数组中至少有一个是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改数组。
 * <p>
 * <p>
 * 例如：如果数组为长度为8的{2，3，5，4，3，2，6，7}。
 * 那么对应的输出是重复的数字2或者3
 */
class FindNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 1, 2, 6, 7};
        System.out.println(method1(numbers));
        System.out.println(method2(numbers));
    }

    /**
     * 首先最容易想到的是啥？ 既然不能修改数组，那我就新建一个辅助数组或其他容器，如HashMap
     * 然后挨个往里面添加。添加也是有技巧的，数字为啥，我就往那个下标的地方添加。因为他的大小不超过数组长度
     * <p>
     * 这个就类似于 桶的解法。
     * <p>
     * 如果题目还有别的要求，比如 我要知道这个数组里面全部的重复的数字，并且每个重复了几次
     * 那么我们还是按照上面的方法。但是这个时候我们不是等于就返回，而是那个下标的数字加1，
     * 最后我们再遍历一遍数组，输出 大于1的那些数，并且还可以根据那个下标的数字是几而得知重复了几次
     *
     * @param numbers
     * @return 负数表示出错。正数表示为要找到的数
     */
    private static int method1(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        // 这个也可以直接使用 HashMap往里面添加，和我题目一里面的类似
        int[] ints = new int[numbers.length];
        for (int number : numbers) {
            // 如果等了那就可以直接返回
            if (ints[number] == number) {
                return number;
            }
            ints[number] = number;
        }
        return -1;
    }

    /**
     * 方法二可以采用二分法来做
     * <p>
     * 1.我们可以把 1~n 分为 1~m 和 m+1~n .
     * 2.统计1~m区间的数字的个数，如果1~m区间中的数字大于m，那么说明这个区间中一定有重复的数
     * 3.然后重复上述操作
     *
     * @param numbers
     * @return
     */
    private static int method2(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int start = 1;
        int end = numbers.length - 1;

        while (end >= start) {
            // 找出中位数 middle
            int middle = ((end - start) >> 1) + start;
            int count = 0;

            for (int number : numbers) {
                if (number <= middle && number >= start) {
                    count++;
                }
            }
            if(end == start){
                if(count>1){
                    return start;
                }else{
                    break;
                }
            }
            // 说明 重复的数在这个区间
            if (count > middle - start + 1) {
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }
}
