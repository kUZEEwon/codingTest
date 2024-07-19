package network;
import java.util.*;

class Solution {

    private boolean[] visited;
    private int numVertices;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        System.out.println("\n답 : " +solution.solution(3, computers));
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        numVertices = n;

        visited = new boolean[n]; // visited 배열 초기화

        // 모든 정점에 대해서 dfs를 수행하여 네트워크 개수 계산
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++; // 새로운 네트워크를 찾으면 카운트 증가
            }
        }
        return answer;
    }



    // DFS 구현
    public void dfs(int startVertex, int[][] adjacencyMatrix) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print( vertex + " ");
            System.out.println();
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    System.out.println("\nstack : "+stack);
                    visited[i] = true;
                }
            }

        }
    }
}