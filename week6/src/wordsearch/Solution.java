package wordsearch;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 첫 번째 문자와 일치하는 경우 DFS 시작
                if (board[i][j] == word.charAt(0)) {
                    if (wordSearch(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false; // 단어를 찾지 못한 경우
    }

    static boolean wordSearch(char[][] board, String word, int row, int col, int index) {
        // 기저 조건: 현재 인덱스가 단어의 길이와 일치하면 단어를 찾은 것
        if (index == word.length()) {
            return true;
        }

        // 경계 조건: 격자를 벗어나거나 문자 불일치 경우
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // 현재 위치 방문 처리
        char temp = board[row][col];
        board[row][col] = '#'; // 임시 방문 마킹

        // 상하좌우 탐색
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (wordSearch(board, word, newRow, newCol, index + 1)) {
                return true; // 다음 위치에서 단어를 찾은 경우
            }
        }

        // 백트래킹: 방문 기록에서 현재 위치 제거
        board[row][col] = temp;
        return false; // 단어를 찾지 못한 경우
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

    //    System.out.println("Word '" + word1 + "' exists: " + solution.exist(board1, word1)); // true


      System.out.println("Word '" + word2 + "' exists: " + solution.exist(board1, word2)); // true

     //   System.out.println("Word '" + word3 + "' exists: " + solution.exist(board1, word3)); // false


    }
}
