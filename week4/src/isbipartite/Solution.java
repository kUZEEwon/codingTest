package isbipartite;

import java.util.*;

/*
* 이분 그래프인지 확인하는 방법?
* 서로 인접한 정점이 같은 색이면 이분 그래프가 아님(FALSE)
*
* BFS,DFS로 탐색하면서 정점을 방문할 때 마다 두가지색 중 하나를 칠한다.
* 다음 정점을 방문하면서 자신과 인접한 정점은 자신과 다른 색으로 칠한다.
* */
class Solution {


    static final int RED = -1;
    static final int BLUE = 1;

    static int[] colors; // 색 {RED 1 or BLUE -1}
    static boolean checkBipartite; // 이분 그래프인지 아닌지 확인

    public static void bfs(int[][] graph, int startVertex, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        colors[startVertex] = color; // 루트 정점 방문 표시 + 색 표시


        // 큐가 비어있지 않고 이분 그래프 == ture 면 반복
        while (!queue.isEmpty() && checkBipartite) {
            int curVertex = queue.poll();


            for (int nextVertex : graph[curVertex]) {
                if (colors[nextVertex] == 0) {
                    queue.offer(nextVertex);
                    colors[nextVertex] = colors[curVertex] * -1; // 인접한 정점을 다른 색으로 지정
                }// 서로 인접한 정점의 색이 같은 색이면 이분 그래프가 아니다.
                else if (colors[curVertex] + colors[nextVertex] != 0) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        // colors 배열 초기화
        colors = new int[graph.length];
        checkBipartite = true; // 초기화


        for (int i = 0; i < graph.length; i++) {
            if (!checkBipartite) {break;}

            if(colors[i] == 0) {
                bfs(graph, i, RED);
            }
        }
        return checkBipartite;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(solution.isBipartite(graph));
    }
}