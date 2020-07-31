package com.leosanqing.leetcode.easy.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 下午4:45
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: 1
 * `          Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * `          Note that the row index starts from 0.
 * `          In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * `          Example:
 * `              Input: 3
 * `              Output: [1,3,3,1]
 * @Version: 1.0
 */
public class _119_pascals_triangleII {
    public static void main(String[] args) {
        generate(3);
    }

    public static List<Integer> generate(int numRows) {
        List<Integer> answer = new ArrayList<>(numRows + 1);

        answer.add(0, 1);

        for (int i = 1; i <= numRows; i++) {
            Integer integer = 1;
            answer.add(i, 1);
            for (int j = 1; j < i; j++) {
                Integer integer1 = answer.get(j);
                answer.set(j, integer + integer1);
                integer = integer1;
            }
        }
        return answer;
    }
}
