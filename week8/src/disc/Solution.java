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
        int n = jobs.length;
        // 작업을 요청 되는 시점 순으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        int totalWaitTime = 0;
        int currentTime = 0;
        int jobindex = 0;

        // 우선순위 큐를 사용해서 현재 시점에서 소요 시간이 가장 짧은 작업을 선택한다.
        Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);

        while (jobindex < n || !pq.isEmpty()){
            // 현재 시간에서 처리할 수 있는 작업들을 우선 순위 큐에 추가한다.
            while (jobindex < n && jobs[jobindex][0] <= currentTime){
                pq.offer(jobs[jobindex]);
                jobindex++;
            }

            if (pq.isEmpty()) {
                // 큐가 비어있다면 다음 작업의 도착 시점까지 시간을 이동합니다.
                if (jobindex < n) {
                    currentTime = jobs[jobindex][0];
                }
                continue;
            }


            // 큐에서 가장 짧은 작업을 꺼내서 처리한다.
            int[] job = pq.poll();
            int startTime = currentTime;
            int finishTime = startTime + job[1];
            int waitTime = finishTime - job[0];

            totalWaitTime += waitTime;
            currentTime =finishTime;
            printDebugInfo(job, startTime, finishTime, waitTime, currentTime, totalWaitTime, pq);

        }

        return totalWaitTime/n;
    }
    private void printDebugInfo(int[] job, int startTime, int finishTime, int waitTime, int currentTime, int totalWaitTime, Queue<int[]> pq) {
        System.out.println("Processing Job: [Start: " + job[0] + ", Duration: " + job[1] + "]");
        System.out.println("Start Time: " + startTime);
        System.out.println("Finish Time: " + finishTime);
        System.out.println("Wait Time: " + waitTime);
        System.out.println("Current Time: " + currentTime);
        System.out.println("Total Wait Time: " + totalWaitTime);
        System.out.println("Remaining Jobs in Queue: " + pq.size());
        for (int[] remainingJob : pq) {
            System.out.println("  - Job in Queue: [Start: " + remainingJob[0] + ", Duration: " + remainingJob[1] + "]");
        }
        System.out.println("---------------------------------------------------");
    }
}
