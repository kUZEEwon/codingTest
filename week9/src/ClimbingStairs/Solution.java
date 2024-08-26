package ClimbingStairs;

public class Solution {
    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;

        System.out.println("Number of ways to climb " + n1 + " stairs: " + solution(n1));
        System.out.println("Number of ways to climb " + n2 + " stairs: " + solution(n2));
    }
}
