package coinChange;


import java.util.Arrays;


class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 테스트 케이스
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(solution.solution(coins1, amount1)); // 출력: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(solution.solution(coins2, amount2)); // 출력: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(solution.solution(coins3, amount3)); // 출력: 0
    }
    public int solution(int[] coins, int amount) {
        // DP 배열 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 초기 값을 amount + 1로 설정
        dp[0] = 0; // 금액이 0일 때는 동전이 필요 없으므로 0으로 설정

        // DP 테이블 채우기
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            // 디버깅을 위한 print 문 추가
            System.out.println("After processing amount " + i + ": " + Arrays.toString(dp));
        }

        // 결과 반환
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
