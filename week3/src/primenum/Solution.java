package primenum;

import java.util.*;


class Solution {
    int answer = 0;
    // HashSet을 사용하여 중복 제거
    HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17"));
    }
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        // 순열 생성 함수 호출
        DFS(visited,numbers,"",0);

        for (int num : set) {
            if(isPrime(num)) answer++;
        }

        return answer;
    }
    boolean isPrime(int number) {
        // 1은 소수가 아님
        if (number <= 1) {
            return false;
        }

        // 2와 3은 소수
        if (number <= 3) {
            return true;
        }

        // 2 또는 3으로 나누어 떨어지면 소수가 아님
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // 5부터 제곱근까지의 숫자로 나누어봄
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    void DFS(boolean[] visited, String numbers, String s, int depth) {
        if(depth >= numbers.length()) return;
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            set.add(Integer.parseInt(s + numbers.charAt(i)));
            DFS(visited, numbers, s + numbers.charAt(i), depth + 1);
            visited[i] = false;

        }
    }
}