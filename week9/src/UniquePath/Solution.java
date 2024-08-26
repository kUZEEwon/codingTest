package UniquePath;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,2));
    }
    public int solution(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=0;
            }
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] =1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(dp[i][j] == 0) dp[i][j] = dp[i - 1][j] + dp[i ][j-1];
            }
        }

        //print dp
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >=0; j--) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }
}
