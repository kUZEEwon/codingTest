package twoqueuesame;
// https://campus.programmers.co.kr/tryouts/139161/challenges?language=java
/*
* 이 문제는 주어진 두 개의 큐에서 원소를 추출(pop)하고 다른 큐에 삽입(insert)하는 작업을 통해
* 두 큐의 원소 합을 동일하게 만들기 위한 최소 작업 횟수를 구하는 문제입니다. 이를 해결하기 위해, 우리는 두 큐의 원소를 적절히 이동시키는 과정을 구현해야 합니다.

이 문제를 해결하기 위한 접근 방식:

1. 두 큐의 총 합을 계산하여, 목표 합이 가능한지 확인합니다. 만약 두 큐의 총 합이 홀수라면 두 큐의 합을 동일하게 만드는 것은 불가능하므로 -1을 반환합니다.
2. 두 큐를 하나의 리스트로 확장하여 슬라이딩 윈도우 방식으로 큐의 원소를 이동시키는 것을 시뮬레이션 합니다.
3. 두 큐의 합이 동일해질 때까지 원소를 이동시키며, 최소 작업 횟수를 기록합니다.
* */


import java.util.*;
// [3, 2, 7, 2]	[4, 6, 5, 1]	2
public class TwoQueueSame {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(sol.solution(queue1, queue2));  // Output: 2
    }

}


                                                                                                                 
class Solution {
    public int solution(int[] queue1, int[] queue2) {
       /* int n = queue1.length;

        // 두 큐의 초기합을 기록한다.
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long q1Sum = 0;
        long q2Sum = 0;

        for(int value : queue1){
            q1.add(value);
            q1Sum += value;
        }

        for(int value : queue2){
            q2.add(value);
            q2Sum += value;
        }

        if((q1Sum + q2Sum) % 2 != 0){
            return -1;
        }

        // 3n동안 반복한다.
        for(int i=0; i< 3*n; i++){
            // 두 큐의 합이 같은 경우 정답을 반환한다.
            if(q1Sum == q2Sum)
            {
              return i;

            } else if (q1Sum > q2Sum) { // q1Sum의 합이 더 큰 경우
                // queue1의 원소를 pop한다.
                int val = q1.poll();
                // pop된 원소를 queue2에 insert
                q2.add(val);
                // 해당 원소의 이동을 두 큐의 합에 각각 반영한다.
                q2Sum += val;
                q1Sum -= val;

            } else{ // q2Sum의 합이 더 큰 경우
                // queue2의 원소를 pop한다.
                int val = q2.poll();
                // pop된 원소를 queue1에 insert
                q1.add(val);
                // 해당 원소의 이동을 두 큐의 합에 각각 반영한다.
                q1Sum += val;
                q2Sum -= val;
            }

        }

        // 3n의 반복해도 답을 구하지 못하면
        return -1;
*/

        // 투포인터 사용
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;
        int n = queue1.length;
        int[] combinedQueue = new int[2 * n];

        System.arraycopy(queue1, 0, combinedQueue, 0, n);
        System.arraycopy(queue2, 0, combinedQueue, n, n);

        int i = 0, j = n;
        int count = 0;
        long currentSum = sum1;
        int minOperations = Integer.MAX_VALUE;

        while (i <= j && j < 2 * n) {
            if (currentSum == target) {
                return count;

            } else if (currentSum < target) {
                count++;
                currentSum += combinedQueue[j++];
            } else {
                count++;
                currentSum -= combinedQueue[i++];
            }
        }

        return currentSum != target ? -1:count;
    }


}
/*
        다른 방식
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;
        int n = queue1.length;
        int[] combinedQueue = new int[2 * n];

        System.arraycopy(queue1, 0, combinedQueue, 0, n);
        System.arraycopy(queue2, 0, combinedQueue, n, n);

        int i = 0, j = n;
        int count = 0;
        long currentSum = sum1;
        int minOperations = Integer.MAX_VALUE;

        while (i <= j && j < 2 * n) {
            if (currentSum == target) {
                minOperations = Math.min(minOperations, count);
                currentSum -= combinedQueue[i++];
            } else if (currentSum < target) {
                count++;
                currentSum += combinedQueue[j++];
            } else {
                count++;
                currentSum -= combinedQueue[i++];
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;*/