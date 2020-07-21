package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/21 上午9:07
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * `          Given a 2D board and a word, find if the word exists in the grid.
 * `          The word can be constructed from letters of sequentially adjacent cell,
 * `          where "adjacent" cells are those horizontally or vertically neighboring.
 * `          The same letter cell may not be used more than once.
 * `          给定一个2D板和一个单词，查找单词是否存在于网格中。
 * `          该单词可以由顺序相邻的单元格的字母构成，
 * `          其中“相邻”单元是水平或垂直相邻的单元。
 * `          同一字母单元不得重复使用。
 * `      Example:
 * `          board = [
 * `                      ['A','B','C','E'],
 * `                      ['S','F','C','S'],
 * `                      ['A','D','E','E']
 * `                  ]
 * `          Given word = "ABCCED", return true.
 * `          Given word = "SEE", return true.
 * `          Given word = "ABCB", return false.
 * @Version: 1.0
 */
public class _79_word_search {
    static boolean flag = false;

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] isUsed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && bfs(board, word, i, j, 0, isUsed)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean bfs(char[][] board, String word, int x, int y, int index, boolean[][] isUsed) {

        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
            if (isUsed[x][y]) {
                return false;
            }

            if (word.charAt(index) == board[x][y]) {
                isUsed[x][y] = true;
                if (index == word.length() - 1) {
                    return true;
                }

                if (bfs(board, word, x - 1, y, index + 1, isUsed)
                        || bfs(board, word, x, y + 1, index + 1, isUsed)
                        || bfs(board, word, x + 1, y, index + 1, isUsed)
                        || bfs(board, word, x, y - 1, index + 1, isUsed)
                ) {
                    return true;
                }

                isUsed[x][y] = false;

            }
            return false;
        }
        return false;
    }

}
