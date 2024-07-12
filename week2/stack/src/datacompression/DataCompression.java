package datacompression;

public class DataCompression {
    public static void main(String[] args) {
        String input = "aabbaccc";
        Solution sol = new Solution();
        System.out.println(sol.solution(input));

    }
}

/*
* 해결 전략

	1.	단위 설정: 문자열을 자를 단위를 설정합니다. 단위는 1부터 시작하여 최대로 자를 수 있는 s.length() / 2까지 고려합니다. 왜냐하면 그 이상의 단위로 자를 경우에는 더 이상 압축 효과가 없기 때문입니다.
	2.	문자열 자르기와 압축하기: 각 단위별로 문자열을 잘라서 압축합니다.
	•	예를 들어, 단위가 2일 때, “aabbaccc”는 “2a2ba3c”로 압축됩니다.
	•	단위가 3일 때, “aabbaccc”는 “2a2bac3”으로 압축됩니다.
	3.	압축된 문자열 계산: 각 단위별로 압축된 결과의 길이를 계산하고, 그 중 가장 짧은 길이를 찾습니다.
	4.	결과 반환: 모든 단위에 대해 최소 길이를 구한 후 반환합니다.

구체적인 구현 단계

	1.	단위별로 문자열 자르기: for 반복문을 사용하여 단위를 1부터 s.length() / 2까지 변화시키며 문자열을 잘라봅니다.
	2.	압축된 문자열 구하기: 각 단위별로 prev 문자열과 비교하여 연속된 문자열의 개수를 세고, 압축된 결과를 StringBuilder에 저장합니다.
	3.	나머지 문자열 처리: 문자열을 모두 자르고 나면 남은 부분을 그대로 추가합니다.
	4.	최소 길이 비교: 각 단위별로 계산된 압축된 문자열의 길이를 비교하여 가장 짧은 길이를 answer 변수에 저장합니다.
	5.	결과 반환: 모든 단위에 대해 최소 길이를 구한 후 answer를 반환합니다.

* */
class Solution {
    public int solution(String s) {
        // 최악의 경우 전체 길이로 초기화
        int answer = s.length();

        // i: 자르는 단위
        for(int i = 0; i <= s.length()/2; i++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, i); // 초기 비교 문자열
            int cnt = 1; // 초기 비교 문자열이 나온 횟수

            // j: 단위 i씩 증가하며 문자열 자름
            for(int j = i; j < s.length() - i; j+=i) {
                String sub = s.substring(j, j+i); // 비교할 문자열

                if(prev.equals(sub)) {
                    cnt++;
                }else {
                    // 연속하지 않으면 지금까지 압축된 문자열 추가
                    compressed.append(cnt > 1 ? cnt : "").append(prev);
                    prev=sub;
                    cnt=1;
                }
            }

            // 마지막 남은 문자열 처리
            compressed.append(cnt > 1 ? cnt : "").append(prev);

            // 나머지 처리
            if (s.length() % i != 0) {
                compressed.append(s.substring(s.length() - s.length() % i));
            }

            // 최소 길이 업데이트
            answer = Math.min(answer, compressed.length());

        }

             return answer;

    }
}