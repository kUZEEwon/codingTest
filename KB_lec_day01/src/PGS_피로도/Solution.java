package PGS_피로도;
import java.util.*;
// (최소 필요 피로도, 소모 피로도)
class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        int curr_piro = -1 ; // 현재 피로도

        // cnt: 탐험한 던젼의 개수, k: 남은 피로도
        DFS(dungeons, visited, k, 0);

        return answer;
    }

    private void DFS(int[][] dungeons, boolean[] visited, int k, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && k >=dungeons[i][0]){
                visited[i] = true;
                DFS(dungeons, visited, k - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k=80;
        int[][] dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution.solution(k, dungeons));
    }
}
