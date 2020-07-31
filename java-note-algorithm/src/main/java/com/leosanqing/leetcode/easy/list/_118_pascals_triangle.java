package com.leosanqing.leetcode.easy.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 下午4:05
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: 1
 * `          Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * `          In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * `      Example:
 * `          Input: 5
 * `          Output: [      [1],     [1,1],    [1,2,1],   [1,3,3,1],  [1,4,6,4,1] ]
 * @Version: 1.0
 */
public class _118_pascals_triangle {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> answer = new ArrayList<>();


        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(j, 1);
                    continue;
                }

                list.add(j, answer.get(i - 2).get(j - 1) + answer.get(i - 2).get(j));

            }
            answer.add(new ArrayList<>(list));
        }
        return answer;

    }
}
