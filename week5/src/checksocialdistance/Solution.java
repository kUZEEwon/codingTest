package checksocialdistance;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[][] DIRECTIONS = {
            {-1, 0}, // 위
            {1, 0},  // 아래
            {0, -1}, // 왼쪽
            {0, 1}   // 오른쪽
    };

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            result[i] = checkPlace(places[i]) ? 1 : 0;
        }
        return result;
    }
    // 모든 사람이 거리두기를 잘하고 있는지 체크하는 함수
    // 모두 다 잘 지키면 return true
    // 한명이라도 안지키면 return false
    private boolean checkPlace(String[] place) {
        int n = place.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0}); // 현재 위치와 거리 초기화
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
           // System.out.println("curr : " + curr[0] + ", " + curr[1] + ", " + curr[2] );
            int cx = curr[0], cy = curr[1], dist = curr[2];
            if(dist >2) continue;
            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny] && place[nx].charAt(ny) != 'X') {
                    // 다음 노드가 X면 파티션이라 이동이 불가능하다.
//                    System.out.println("place : "+Arrays.toString(place));
                    if (place[nx].charAt(ny) == 'P' && dist + 1 <= 2) {
                        return false; // 거리 조건을 지키지 않는 경우
                    }

                    if (dist + 1 < 2) {
                        // 2 미만 일때만 다음 노드를 예약하기
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1}); // 거리 증가
                   //     System.out.println("queue: " + Arrays.toString(place));
                    }
                }
            }
        }
        return true; // 거리두기 준수
    }


    public static void main(String[] args) {
        Solution checker = new Solution();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = checker.solution(places);
        System.out.println(Arrays.toString(result)); // [1, 0, 1, 1, 1]
    }
}

