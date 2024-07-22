package targetNum;

class Solution {

    public int solution(int[] numbers, int target) {

        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int depth, int sum) {/*
        // basecase
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int answer=0;
        answer += dfs(numbers, target, depth + 1, sum + numbers[depth]); // target이면 1이고 아님 0임
        answer += dfs(numbers, target, depth + 1, sum - numbers[depth]);

        return answer;*/

        System.out.println("index: " + depth + ", sum: " + sum);

        if (depth == numbers.length) {
            if (sum == target) {
                System.out.println("Found a solution: " + sum);
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        count += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        System.out.println("Trying + " + numbers[depth] + ", count: " + count);
        count += dfs(numbers, target, depth + 1, sum - numbers[depth]);
        System.out.println("Trying - " + numbers[depth] + ", count: " + count);
        return count;

    }
    public void backtrack(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}