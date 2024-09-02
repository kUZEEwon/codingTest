package primenum;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("011"));
    }
    int answer = 0;

    public int solution(String numbers) {
        answer = 0;
        // 중복 제거를 위해 Set 사용
        Set<Integer> result = new HashSet<>();

        // 순열 생성 함수 호출
        generatePermutations("", numbers, result);
        System.out.println(result);
        for (int num : result) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i ++) {
            if (number % i == 0 ) return false;
        }
        return true;
    }

    void generatePermutations(String prefix, String remaining, Set<Integer> result) {
        int n = remaining.length();
        if (!prefix.isEmpty()) {
            result.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            System.out.println("prefix: " + prefix + " ,remaining: " + remaining);
            System.out.println(result);
            generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }

}