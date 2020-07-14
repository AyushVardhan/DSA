package com.Leetcode;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "CESEEEF"));
    }

    static boolean[][] lookUp;

    private static boolean exist(char[][] board, String word) {
        if (board.length <= 0 || board[0].length <= 0 || word.length() <= 0)
            return false;

        lookUp = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && findWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean findWord(char[][] board, String word, int posR, int posC, int currPos) {
        if (currPos == word.length())
            return true;

        if (posC < 0 || posR < 0 || posR >= board.length || posC >= board[0].length || board[posR][posC] != word.charAt(currPos) || lookUp[posR][posC])
            return false;

        lookUp[posR][posC] = true;

        if (findWord(board, word, posR + 1, posC, currPos + 1) ||
                findWord(board, word, posR, posC + 1, currPos + 1) ||
                findWord(board, word, posR - 1, posC, currPos + 1) ||
                findWord(board, word, posR, posC - 1, currPos + 1)
        ) {
            return true;
        }

        lookUp[posR][posC] = false;
        return false;
    }
}
