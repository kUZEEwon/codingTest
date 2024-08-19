package taxfee;
// https://campus.programmers.co.kr/tryouts/145400/challenges#
import java.util.*;

class Solution {
    public int[] dijkstra(int n, int start, Map<Integer, List<Edge>> graph ) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int curr_node = curr.node;
            int curr_cost = curr.cost;

            if(curr_cost > dist[curr_node]) {continue;}

            for(Edge neighbor : graph.get(curr_node)) {
                int newCost = neighbor.cost + curr_cost;
                if(newCost < dist[neighbor.node]) {
                    dist[neighbor.node] = newCost;
                    pq.add(new Edge(neighbor.node, newCost));
                }
            }
        }
        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 1; i < n+1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : fares) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int[] distFromStart = dijkstra(n, s, graph);
        int[] distFromA = dijkstra(n, a, graph);
        int[] distFromB = dijkstra(n, b, graph);

        int mincost = Integer.MAX_VALUE;
        for(int i = 0; i <=n; i++) {
            mincost = Math.min(mincost, distFromStart[i] + distFromA[i] + distFromB[i]);
        }

        return mincost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int n= 6, s=4, a=6, b=2;
        //result == 82
        int result = solution.solution(n, s, a, b, graph);
        System.out.println("result >> " +result);
    }
}