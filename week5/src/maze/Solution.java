package maze;
// https://campus.programmers.co.kr/tryouts/143318/challenges?language=java


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {


    // (x,y,거리)

    private static  int[][] directions = {
            {-1, 0}, // 위
            {1, 0},  // 아래
            {0, -1}, // 왼쪽
            {0, 1}   // 오른쪽
    };


    // 다음 위치가 유효한지 확인 (그리드 내에 있고 벽이 아님)
    public static boolean isValid(String[] maps, int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() && maps[nx].charAt(ny) != 'X';
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cell = maps[i].charAt(j);
                if (cell == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (cell == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (cell == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        // 시작점 => 레버
        int toLever = bfs(maps, start, lever);
        if(toLever == -1){return -1;}

        // 레버 => 목표 지점
        int toExit = bfs(maps, lever, exit);
        if(toExit == -1){return -1;}

        return toExit+ toLever;
    }


    private int bfs(String[] maps, int[] start, int[] end) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1],0});
        visited[start[0]][start[1]] = true;


        while (!queue.isEmpty()) {


                int[] cur = queue.poll();
                System.out.println( "cur : "+ Arrays.toString(cur));
                int curX = cur[0];
                int curY = cur[1];
                int distance = cur[2];

                // 도착점에 도달한 경우
                if (curX == end[0] && curY == end[1]) {
                    return distance;
                }

                for (int[] dir : directions) {
                    int nextRow = curX + dir[0];
                    int nextCol = curY + dir[1];

                    if (isValid(maps, nextRow, nextCol) && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true; // 방문 표시
                        queue.offer(new int[]{nextRow, nextCol,distance+1});
                        // Queue의 모든 원소 출력
                        for (int[] element : queue) {
                            System.out.println("Queue의 원소: "+Arrays.toString(element));
                        }

                    }
                }


            System.out.println();
        }

        return -1; // 경로가 없는 경우

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int result = solution.solution(maps);
        System.out.println("result is " +result); // 출력: 16
    }
}