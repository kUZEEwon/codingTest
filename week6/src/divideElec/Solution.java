package divideElec;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private int vertices; // 정점의 개수
    private List<List<Integer>> adj; // 인접 리스트

    public static void main(String[] args) {
        // 주어진 입력
        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        // Solution 객체 생성 및 문제 해결
        Solution solution = new Solution();
        int result = solution.solution(n, wires);

        // 결과 출력
        System.out.println("Result: " + result);
    }


    public int solution(int n, int[][] wires) {
        vertices = n;
        adj = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접 리스트 만들기
        for (int[] e : wires) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);

        }


        int minDifference = Integer.MAX_VALUE;

        // 모든 엣지를 제거하면서 두 컴포넌트의 크기 차이를 계산
        for (int[] e : wires) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            // 엣지 제거
            adj.get(u).remove(Integer.valueOf(v));
            adj.get(v).remove(Integer.valueOf(u));

            // 두 컴포넌트의 크기를 계산
            int size1 = getComponentSize(u);
            int size2 = vertices - size1;
            System.out.println("최솟값 : " + Math.abs(size1 - size2));
            System.out.println();

            // 최소 차이 업데이트
            minDifference = Math.min(minDifference, Math.abs(size1 - size2));

            // 엣지 복원
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return minDifference;
    }

    // DFS를 사용하여 컴포넌트의 크기를 계산
    private int getComponentSize(int start) {
        boolean[] visited = new boolean[vertices];
        return dfs(start, visited);
    }

    private int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int size = 1;
        System.out.println("Visited node: " + (node + 1));


        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, visited);
            }
        }

        return size;
    }
}
