package divideElec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


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

    int numNode;
    List<List<Integer>> adj;
    int answer;

    public int solution(int n, int[][] wires) {
        answer = n;
        numNode=n;
        adj= new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] wire: wires){
            int u= wire[0], v= wire[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n+1];
        dfs(1,visited);

        return answer;
    }

    int dfs(int start,boolean[] visited){
        visited[start] = true;
        int cnt = 1;
        System.out.println("start: " + start);

        for(int next: adj.get(start)){
            System.out.println("next: " + next);
            System.out.println(Arrays.toString(visited));
            if(!visited[next]){ // next : 3
                cnt+=dfs(next, visited);
                System.out.println("재귀끝!\ncnt: " + cnt);
            }
            System.out.println("한바뀌 끝!");
        }
        System.out.println("다음 start");
        answer = Math.min(answer, Math.abs(numNode - cnt*2));
        return cnt;
    }
}
