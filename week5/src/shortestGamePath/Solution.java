package shortestGamePath;
// https://campus.programmers.co.kr/tryouts/143317/challenges?language=java
import java.util.*;

class Solution {
    private boolean[][] visited;
    private static  int[][] directions = {
            {-1, 0}, // 위
            {1, 0},  // 아래
            {0, -1}, // 왼쪽
            {0, 1}
    };


    public static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }

    public int solution(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        if (grid[0][0] == 0 || grid[row - 1][col - 1] == 0) {
            return -1; // 시작점이나 끝점이 1인 경우
        }
        int[] start = new int[]{0, 0};
        int[] end = new int[]{row-1, col-1};
        int result =  bfs(grid, start,end);

        return result; // BFS 호출
    }

    private int bfs(int[][] grid, int[] start, int[] end) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0,1});
        visited[0][0] = true;


        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int curRow = cur[0];
            int curCol = cur[1];
            int distance = cur[2];

            // 도착점에 도달한 경우
            if (curRow == end[0] && curCol == end[1]) {
                return distance;
            }

            for (int[] dir : directions) {
                int nextRow = curRow + dir[0];
                int nextCol = curCol + dir[1];

                if (isValid(grid, nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    queue.offer(new int[]{nextRow, nextCol, distance+1});

                    visited[nextRow][nextCol] = true; // 방문 표시
                }
            }

        }

        return -1; // 경로가 없는 경우

    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
      Solution solution = new Solution();
        int ans = solution.solution(array);
        System.out.println( "\nanswer is "+ans); // Output: 4
    }
}
