package functiondevelop;
import java.util.*;

public class FunctionDevelop {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = {93, 20, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();
        int[] remainPeriod = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            remainPeriod[i] = ((100 - progresses[i]) % speeds[i] == 0) ?
                    (100 - progresses[i]) / speeds[i] :
                    ((100 - progresses[i]) / speeds[i]) + 1;
            queue.offer(remainPeriod[i]);
        }

        while (!queue.isEmpty()) { // queue가 빌 때까지 반복
            int temp = queue.remove();
            int cnt = 1; // 작업 개수를 1로 초기화

            while (!queue.isEmpty() && queue.peek() <= temp) {
                queue.poll();
                cnt++;
            }

            counts.add(cnt);
        }

        // List를 int[]로 변환
        int[] answer = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }

        return answer;
    }
}