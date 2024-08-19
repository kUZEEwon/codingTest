package maxProbability;

import java.util.*;

public class Solution {
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
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 인접 리스트 만들기
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(v).add(new Edge(u, w));
            graph.get(u).add(new Edge(v, w));
        }

        printGraph(graph);
        double[] costs = new double[n + 1];

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start_node, 1.0));
        costs[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int node = curr.node;
            double prob = curr.cost;

            if(node == end_node) return prob;

            for(Edge neighbor : graph.get(node)){
                int next_node = neighbor.node;
                double next_prob = neighbor.cost;

                double newCost = prob * next_prob;
                if(costs[next_node] < newCost) {
                    costs[next_node] = newCost;
                    pq.add(new Edge(next_node, costs[next_node]));
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.printf("Output: %.5f\n", solution.maxProbability(n1, edges1, succProb1, start1, end1));

        // Example 2
        int n2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        int start2 = 0;
        int end2 = 2;
        System.out.printf("Output: %.5f\n", solution.maxProbability(n2, edges2, succProb2, start2, end2));

        // Example 3
        int n3 = 3;
        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;
        System.out.printf("Output: %.5f\n", solution.maxProbability(n3, edges3, succProb3, start3, end3));
    }
}