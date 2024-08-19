package NetworkDelayTime;

import java.util.*;

class Solution {
    public void printGraph(Map<Integer, List<Edge>> graph) {
        for (Map.Entry<Integer, List<Edge>> entry : graph.entrySet()) {
            int node = entry.getKey();
            List<Edge> edges = entry.getValue();

            System.out.print(node + ": ");
            for (Edge edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Edge(v, w));
        }
        printGraph(graph);

        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1]; // n + 1로 크기를 설정
        Arrays.fill(dist, INF);

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.node] < cur.cost) continue;

            List<Edge> edges = graph.get(cur.node);
            if (edges != null) {  // 현재 노드에 연결된 간선이 있는지 확인
                for (Edge edge : edges) {
                    int newDist = cur.cost + edge.cost;
                    if (newDist < dist[edge.node]) {
                        dist[edge.node] = newDist;
                        pq.add(new Edge(edge.node, newDist));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예시 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4, k1 = 2;
        int result1 = solution.networkDelayTime(times1, n1, k1);
        System.out.println("Example 1: " + result1); // 출력: 2

        // 예시 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2, k2 = 1;
        int result2 = solution.networkDelayTime(times2, n2, k2);
        System.out.println("Example 2: " + result2); // 출력: 1

        // 예시 3
        int[][] times3 = {{1, 2, 1}};
        int n3 = 2, k3 = 2;
        int result3 = solution.networkDelayTime(times3, n3, k3);
        System.out.println("Example 3: " + result3); // 출력: -1

        // 추가적인 테스트 케이스를 여기에 작성할 수 있습니다.
    }
}
