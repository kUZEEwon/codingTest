package PGS_문자열압축;
/*1. 전달받은 매개변수 문자열 s의 길이를 구하여 answer에 할당합니다.



2. 반복문을 통해 1개 단위부터 압축 단위를 늘려가며 문자열을 확인합니다.



3. 그 과정에서 0번째부터 step만큼의 문자열을 추출하고, step 크기만큼 증가시키며 이전 문자열과 비교합니다.



4. 이전 문자열과 동일하다면 count를 1 증가시키고, 다르다면 prev와 count의 상태를 다시 초기화합니다.



5. 내부 반복문이 종료되면 남아 있는 문자열에 대하여 처리하고 min( )를 통해 answer과 compressed길이를 비교하여

   더 작은 값을 answer에 갱신합니다.



6. 반복문이 모두 끝나면 answer 값을 반환합니다.*/
import java.util.*;
class Solution {
    public int solution(String s) {

        int s_len = s.length();
        int answer = s_len;

        // 1개 단위(step) 부터 압축 단위를 늘려가며 확인
        for (int step = 1; step <= s_len /2; step++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;
            String prev = s.substring(0, step);
            for (int i = step; i < s_len; i += step) {
                String curr = s.substring(i, Math.min(i + step, s_len));
                if(curr.equals(prev)) {count++;}
                else {
                    sb.append(count >=2  ? count+prev:prev);
                    count = 1;
                    prev = curr;
                }
            }

            // 마지막 부분 처리
            sb.append(count >=2  ? count+prev:prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababcdcdababcdcd";
        System.out.println(solution.solution(s));
    }
}