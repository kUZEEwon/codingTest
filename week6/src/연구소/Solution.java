package 연구소;

import java.util.*;

public class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static void bfs(int[][] grid, int n, int m, List<int[]> virusPositions, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>(virusPositions);
        for (int[] pos : virusPositions) {
            visited[pos[0]][pos[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int countSafeArea(int[][] grid, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        List<int[]> virusPositions = new ArrayList<>();

        // Find all virus positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                }
            }
        }

        bfs(grid, n, m, virusPositions, visited);

        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

    private static int maxSafeArea(int n, int m, int[][] grid) {
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        int maxSafeArea = 0;
        // Try all combinations of placing 3 walls
        for (int i = 0; i < emptyCells.size(); i++) {
            for (int j = i + 1; j < emptyCells.size(); j++) {
                for (int k = j + 1; k < emptyCells.size(); k++) {
                    int[][] newGrid = new int[n][m];
                    for (int x = 0; x < n; x++) {
                        System.arraycopy(grid[x], 0, newGrid[x], 0, m);
                    }

                    newGrid[emptyCells.get(i)[0]][emptyCells.get(i)[1]] = 1;
                    newGrid[emptyCells.get(j)[0]][emptyCells.get(j)[1]] = 1;
                    newGrid[emptyCells.get(k)[0]][emptyCells.get(k)[1]] = 1;

                    int safeArea = countSafeArea(newGrid, n, m);
                    maxSafeArea = Math.max(maxSafeArea, safeArea);
                }
            }
        }

        return maxSafeArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxSafeArea(n, m, grid));
    }
}

