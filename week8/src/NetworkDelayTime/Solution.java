package NetworkDelayTime;
import java.util.*;

class Solution {
    public void printGraph(Map<Integer, List<int[]>> graph) {
        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            int node = entry.getKey();
            List<int[]> edges = entry.getValue();

            System.out.print(node + ": ");
            for (int[] edge : edges) {
                System.out.print(Arrays.toString(edge) + " ");
            }
            System.out.println();
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 인접 리스트를 사용하여 그래프를 표현
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }
        printGraph(graph);
        // 최단 거리 배열, 초기값은 무한대
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 우선순위 큐 사용, {노드, 거리}를 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0]; // node
            int currentDist = current[1]; // 거리

            // 만약 큐에서 꺼낸 거리가 dist보다 크면 무시(왜냐면 dist가 inf일 가능성)
            if (currentDist > dist[u]) {
                continue;
            }

            // 현재 노드와 연결된 모든 인접 노드에 대해
            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    int newDist = dist[u] + w;

                    // 만약 새로운 경로가 더 짧다면 업데이트
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new int[]{v, newDist});
                    }
                }
            }
        }

        // 모든 노드에 대한 최단 시간을 확인하여 최대값을 찾음
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
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
    }
}
