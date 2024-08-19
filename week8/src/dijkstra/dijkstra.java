package dijkstra;

import java.util.*;

class dijkstra {
    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>() {{
            put(1, List.of(new Edge(2, 2), new Edge(4, 1)));
            put(2, List.of(new Edge(3, 2), new Edge(5, 2), new Edge(6, 4)));
            put(3, List.of(new Edge(6, 4)));
            put(4, List.of(new Edge(7, 5)));
            put(5, List.of(new Edge(8, 1)));
            put(6, List.of(new Edge(5, 3)));
            put(7, List.of(new Edge(6, 7), new Edge(8, 6)));
            put(8, List.of());
        }};

        int distance = dijkstra(graph, 1, 8);
        System.out.println("distance = " + distance);
    }

    private static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end) {

        // 최대 정수값을 INF(Infinite) 상수로 정의 (도달할 수 없는 노드를 표시)
        final int INF = Integer.MAX_VALUE;

        // 모든 노드에 대한 시작 노드까지의 거리 저장 배열 생성 (방문 여부와 최소 비용을 모두 표현)
        int[] dist = new int[graph.size() + 1];
        Arrays.fill(dist, INF);

        // 우선순위 큐 생성 (최소 거리 먼저 처리하기 위해)
        Queue<Entry> pq = new PriorityQueue<>();

        // 시작 노드를 거리 0으로 설정하여 우선순위 큐에 추가
        pq.add(new Entry(start, 0));
        dist[start] = 0;

        // 우선순위 큐가 비어있지 않을 때까지 반복
        while (!pq.isEmpty()) {
            // 현재 처리할 노드 정보 추출 (우선순위 큐에서 최소 거리 노드 꺼내옴)
            // 방문
            Entry current = pq.remove();

            // 이미 처리된 노드라면 (더 짧은 경로 발견됨) 스킵
            if (dist[current.node] < current.distance) continue;

            // 현재 노드에 연결된 모든 간선 확인
            // 예약
            for (Edge edge : graph.get(current.node)) {
                // 연결된 노드까지의 tentative (임시) 거리 계산 (현재 노드 거리 + 간선 가중치)
                int newDist = current.distance + edge.distance;

                // 기존 거리보다 tentative 거리가 더 짧은 경우 갱신
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;  // 최소 거리 갱신
                    pq.add(new Entry(edge.to, newDist)); // 갱신된 거리 정보로 우선순위 큐에 추가
                }
            }
        }

        // 목표 노드까지의 최소 거리 반환
        return dist[end];
    }
}
