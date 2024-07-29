package shortestPathBinaryMatrix;
// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean[][] visited;
    private static  int[][] directions = {
            {-1, 0}, // 위
            {1, 0},  // 아래
            {0, -1}, // 왼쪽
            {0, 1},   // 오른쪽
            // 대각선
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
    };


    public static boolean isValid(int[][] grid,int row, int col) {
        // 그리드의 경계를 벗어나거나 길이 아닌('1')인 경우 종료
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1) {
            return false;
        }
        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1; // 시작점이나 끝점이 1인 경우
        }
        return bfs(grid); // BFS 호출
    }

    private int bfs(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int pathLength = 1; // 경로 길이

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                System.out.println( "cur : "+Arrays.toString(cur));
                int curRow = cur[0];
                int curCol = cur[1];

                // 도착점에 도달한 경우
                if (curRow == grid.length - 1 && curCol == grid[0].length - 1) {
                    return pathLength;
                }

                for (int[] dir : directions) {
                    int nextRow = curRow + dir[0];
                    int nextCol = curCol + dir[1];

                    if (isValid(grid, nextRow, nextCol) && !visited[nextRow][nextCol]) {
                        queue.offer(new int[]{nextRow, nextCol});
                        // Queue의 모든 원소 출력
                        ;
                        for (int[] element : queue) {
                            System.out.println("Queue의 원소: "+Arrays.toString(element));
                        }
                        visited[nextRow][nextCol] = true; // 방문 표시
                    }
                }
            }
            pathLength++; // 다음 레벨로 넘어갈 때 경로 길이 증가
            System.out.println();
        }

        return -1; // 경로가 없는 경우

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 0, 1},
                {1, 0, 0}
        };
        Solution solution = new Solution();
        int ans = solution.shortestPathBinaryMatrix(grid);
        System.out.println( "\nanswer is "+ans); // Output: 4
    }
}