package fatigue;
// https://velog.io/@soorim_yoon/DFS%EC%99%84%EC%A0%84%ED%83%90%EC%83%89-%ED%94%BC%EB%A1%9C%EB%8F%84-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level2
// 도움 받은 풀이

import static java.lang.Math.max;

public class Fatigue {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] dungeons = new int[][] {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(80, dungeons));
    }
}

class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {

        // 방문 여부를 확인
        boolean[] visited = new boolean[dungeons.length];

        // cnt: 탐험한 던전의 개수, k: 남은 피로도
        DFS(dungeons, visited, k, 0);

        return answer;
    }
    void DFS(int[][] dungeons, boolean[] visited ,int k, int cnt) {

        answer =  max(answer,cnt);
        for (int i = 0; i < dungeons.length; i++) {
            // basecase , 재귀 호출
            if(!visited[i]  && k>= dungeons[i][0]){ // 남은 피로도가 최소 피로도 이상이고 방문하지 않은 던전이어야함
                visited[i] = true;
                DFS(dungeons, visited, k - dungeons[i][1], cnt+1); // 다음 던전 방문
                visited[i] = false;
            }
        }
    }
}