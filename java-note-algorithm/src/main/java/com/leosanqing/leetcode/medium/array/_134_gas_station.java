package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 上午9:38
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          There are N gas stations along a circular route,
 * `          where the amount of gas at station i is gas[i].
 * `          You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its
 * next station (i+1).
 * `          You begin the journey with an empty tank at one of the gas stations.
 * `          Return the starting gas station's index
 * `          if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * `
 * `          Note:
 * `              If there exists a solution, it is guaranteed to be unique.
 * `              Both input arrays are non-empty and have the same length.
 * `              Each element in the input arrays is a non-negative integer.
 * `
 * `          沿循环路线有N个加油站，
 * `          其中，第i个站点的天然气量为gas [i]。
 * `          您有一辆带无限油箱的汽车，从第i站到下一个（i + 1）的行车成本为[i]。
 * `          您可以从其中一个加油站的空罐开始旅程。
 * `          返回起始加油站的索引
 * `          如果您可以沿顺时针方向绕过电路一次，否则返回-1。
 * `          注意：
 * `              如果存在解决方案，则保证是唯一的。
 * `              两个输入数组都是非空的，并且具有相同的长度。
 * `              输入数组中的每个元素都是非负整数。
 * `      Example 1:
 * `          Input:
 * `              gas  = [1,2,3,4,5]
 * `              cost = [3,4,5,1,2]
 * `          Output: 3
 * `          Explanation:
 * `              Start at station 3 (index 3) and fill up with 4 unit of gas.
 * `              Your tank = 0 + 4 = 4 Travel to station 4. Your tank = 4 - 1 + 5 = 8 Travel to station 0.
 * `              Your tank = 8 - 2 + 1 = 7 Travel to station 1.
 * `              Your tank = 7 - 3 + 2 = 6 Travel to station 2.
 * `              Your tank = 6 - 4 + 3 = 5 Travel to station 3.
 * `              The cost is 5. Your gas is just enough to travel back to station 3.
 * `              Therefore, return 3 as the starting index.
 * `      Example 2:
 * `          Input:
 * `              gas  = [2,3,4]
 * `              cost = [3,4,3]
 * `          Output: -1
 * `          Explanation:
 * `              You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * `              Let's start at station 2 and fill up with 4 unit of gas.
 * `              Your tank = 0 + 4 = 4 Travel to station 0.
 * `              Your tank = 4 - 3 + 2 = 3 Travel to station 1.
 * `              Your tank = 3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4 unit of gas but you
 * only have 3.
 * `              Therefore, you can't travel around the circuit once no matter where you start.
 * @Version: 1.0
 */
public class _134_gas_station {

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            if (canDoIt(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canDoIt(int[] gas, int[] cost, int start) {
        int g = 0;
        for (int j = 0; j < gas.length; j++) {
            int position = (j + start) % gas.length;
            g += gas[position] - cost[position];
            if (g < 0) {
                return false;
            }
        }
        return true;
    }


}
