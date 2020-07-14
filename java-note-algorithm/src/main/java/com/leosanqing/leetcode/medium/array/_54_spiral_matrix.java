package com.leosanqing.leetcode.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 下午2:57
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * ` `         Given a matrix of m x n elements (m rows, n columns),
 * ` `         return all elements of the matrix in spiral order.
 * ` `         给定一个由m x n个元素组成的矩阵（m行n列），
 * ` `         以螺旋顺序返回矩阵的所有元素。
 * ` `     Example 1:
 * ` `         Input:
 * ` `             [
 * ` `                 [ 1, 2, 3 ],
 * ` `                 [ 4, 5, 6 ],
 * ` `                 [ 7, 8, 9 ]
 * ` `             ]
 * ` `         Output: [1,2,3,6,9,8,7,4,5]
 * ` `     Example 2:
 * ` `         Input:
 * ` `             [
 * ` `                 [1, 2, 3, 4],
 * ` `                 [5, 6, 7, 8],
 * ` `                 [9,10,11,12]
 * ` `             ]
 * ` `         Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @Version: 1.0
 */
public class _54_spiral_matrix {
    public static void main(String[] args) {

        int[][] ints = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        spiralOrder(ints);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();


        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int left = 0, top = 0,
                right = matrix[0].length - 1, bottom = matrix.length - 1;


        while (list.size() < matrix[0].length * matrix.length) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }

        while(list.size()!= matrix.length * matrix[0].length){
            list.remove(list.size()-1);
        }
        return list;
    }


}
