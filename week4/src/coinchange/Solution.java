package coinchange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[] visited;
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(sol.coinChange(coins,11));
    }

    public int coinChange(int[] coins, int amount) {
        visited = new boolean[amount+1];
        return BFS(coins, amount);
    }

    public int BFS(int[] coins, int amount) {
        if(amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0); // 초기 금액 : 0
        int depth = 0; // 사용한 동전 개수

        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;// 다음 깊이로 이동

            for(int i = 0; i < size; i++) {
                int curr= queue.poll(); // queue에서 현재 금액을 꺼냄
                System.out.println("curr: " + curr);

                for(int coin : coins) {
                    int newAmount = curr + coin; // 새로운 금액
                    System.out.println("newAmount: " + newAmount);

                    if(newAmount == amount) {return depth;}

                    if(newAmount < amount && !visited[newAmount]) {
                        visited[newAmount] = true;
                        // System.out.println("visited: " + Arrays.toString(visited));
                        queue.offer(newAmount);
                    }
                }
            }

        }

        // 목표 금액 반환 불가능
        return -1;
    }
}