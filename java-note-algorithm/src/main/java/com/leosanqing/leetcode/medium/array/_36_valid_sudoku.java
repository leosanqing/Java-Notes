package com.leosanqing.leetcode.medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: rtliu
 * @Date: 2020/7/13 上午11:46
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: ` `         Determine if a 9x9 Sudoku board is valid.
 * ` `         Only the filled cells need to be validated according to the following rules:
 * ` `         1. Each row must contain the digits 1-9 without repetition.
 * ` `         2. Each column must contain the digits 1-9 without repetition.
 * ` `         3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 1`
 * 1`
 * 1`          确定9x9数独板是否有效。
 * 1`          仅需根据以下规则验证填充的单元格：
 * 1`          1.每行必须包含数字1-9，不能重复。
 * 1`          2.每列必须包含数字1-9，且不能重复。
 * 1`          3.网格的9个3x3子框中的每个必须包含数字1-9（无重复）。
 *
 * <p>
 * `         Example 1:
 * <p>
 * `             Input:
 * `             [
 * `               ["5","3",".",".","7",".",".",".","."],
 * `               ["6",".",".","1","9","5",".",".","."],
 * `               [".","9","8",".",".",".",".","6","."],
 * `               ["8",".",".",".","6",".",".",".","3"],
 * `               ["4",".",".","8",".","3",".",".","1"],
 * `               ["7",".",".",".","2",".",".",".","6"],
 * `               [".","6",".",".",".",".","2","8","."],
 * `               [".",".",".","4","1","9",".",".","5"],
 * `               [".",".",".",".","8",".",".","7","9"]
 * `             ]
 * `             Output: true
 * `         Example 2:
 * <p>
 * `             Input:
 * `             [
 * `               ["8","3",".",".","7",".",".",".","."],
 * `               ["6",".",".","1","9","5",".",".","."],
 * `               [".","9","8",".",".",".",".","6","."],
 * `               ["8",".",".",".","6",".",".",".","3"],
 * `               ["4",".",".","8",".","3",".",".","1"],
 * `               ["7",".",".",".","2",".",".",".","6"],
 * `               [".","6",".",".",".",".","2","8","."],
 * `               [".",".",".","4","1","9",".",".","5"],
 * `               [".",".",".",".","8",".",".","7","9"]
 * `             ]
 * `             Output: false
 * `             Explanation: Same as Example 1, except with the 5 in the top left corner being
 * `                 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * `         Note:
 * <p>
 * `             A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * `             Only the filled cells need to be validated according to the mentioned rules.
 * `             The given board contain only digits 1-9 and the character '.'.
 * `             The given board size is always 9x9.
 * @Version: 1.0
 */
public class _36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c + "in row" + i) ||
                        !set.add(c + "in column" + j) ||
                        !set.add(c + "in block" + i / 3 + "-" + j/3)
                    ){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
