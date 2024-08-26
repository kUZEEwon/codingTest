package MinClimbingStairs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {10,15,20};
        int[] arr2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        // System.out.println(sol.solution(arr1));
        System.out.println(sol.solution(arr2));
    }
    public int solution(int[] cost) {

        int n = cost.length;

        // DP 배열 초기화
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        // 초기 상태 출력
        System.out.println("Initial dp array: " + Arrays.toString(dp));

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];

            // 각 단계에서의 DP 배열 상태 출력
            System.out.println("dp[" + i + "] = " + dp[i] + " (min(dp[" + (i - 1) + "] = " + dp[i - 1] + ", dp[" + (i - 2) + "] = " + dp[i - 2] + ") + cost[" + i + "] = " + cost[i] + ")");
            System.out.println("Current dp array: " + Arrays.toString(dp));
        }

        // 최종 결과 출력
        int result = Math.min(dp[n - 1], dp[n - 2]);
        System.out.println("Final dp array: " + Arrays.toString(dp));
        System.out.println("Minimum cost to reach the top: " + result);

        return result;
    }

}
