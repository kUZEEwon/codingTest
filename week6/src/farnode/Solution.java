package farnode;

/*
    입출력 예제
*   n	vertex	                                                    return
    6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
* */
//  https://campus.programmers.co.kr/tryouts/143666/challenges?language=java

import java.util.*;
class Solution {

    private int vertices; // 정점의 개수
    private List<List<Integer>> adj; // 인접 리스트

    public int solution(int n, int[][] edge) {
        vertices = n;
        adj = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접 리스트 만들기
        for (int[] e : edge) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);

        return search(0);
    }

    public int search(int startVertex) {
        boolean[] visited = new boolean[vertices]; // 방문 배열
        int[] DIST = new int[vertices]; // 각 정점 까지의 거리 배열
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);
        DIST[startVertex] = 0;

        while (!queue.isEmpty()) {
            int currVertex = queue.poll();

            // 현재 정점과 연결된 모든 정점을 탐색
            for (int neighbor : adj.get(currVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    DIST[neighbor] = DIST[currVertex] + 1;
                }
            }
        }

        int maxdist = 0;
        for (int dist : DIST) {
            if (dist > maxdist) {
                maxdist = dist;
            }
        }

        // 최장 거리에 해당하는 정점의 수를 계산
        int count = 0;
        for (int dist : DIST) {
            if (dist == maxdist) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6; // 정점의 개수
        int[][] edges = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };


        System.out.println("BFS 탐색 결과:");
       Solution solution = new Solution();
       System.out.println(solution.solution(n, edges));
    }
}
