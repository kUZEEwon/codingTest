package disc;
/*
- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
jobs	                    return
[[0, 3], [1, 9], [2, 6]]	9
* */
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = { {0, 3}, {1, 9}, {2, 6} };
        Solution sol = new Solution();
        System.out.println("result >> " +sol.solution(arr));
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        // 두 번째 요소를 기준으로 정렬하는 Comparator 사용
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]); // 두 번째 요소를 기준으로 비교
            }
        });
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int node = jobs[i][0];
            int time = jobs[i][1];
            // 이때까지의 시간 - node + 나의 시간

            answer = answer+ cur - node + time;
            cur = cur + time; // 이때 까지의 시간
        }


        return answer/n;
    }
}
