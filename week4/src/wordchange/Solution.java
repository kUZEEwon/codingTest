package wordchange;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Solution solution = new Solution();
        int result = solution.solution(begin, target, words);
        System.out.println(result); // Output: 4
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0; // 변환 횟수

        // target이 words에 포함안됨 => return 0
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // 큐와 방문처리를 위한 visited 초기화
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // begin을 큐에 추가하고 방문 처리
        queue.offer(begin);
        visited.add(begin);

        // bfs로 구현
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 현재 큐의 사이즈 만큼 반복
            System.out.println("answer: " + answer);
            for (int i = 0; i < size; i++) {
                // 1개 뽑아옴
                String word = queue.poll(); // word : hit
                //현재 단어가 target과 같으면 변환 횟수 변환
                if (word.equals(target)) {
                    return answer;
                }

                // 현재 단어에서 한 개의 알파벳만 바꿔서 words에 포함된 단어로 변환할 수 있는지 확인
                for(int j = 0; j < word.length(); j++) { // word.length : 3
                    char[] chars = word.toCharArray();
                   // System.out.println("chars : " + Arrays.toString(chars)); // chars : [h, i, t]

                    for( char c='a'; c<='z'; c++) {
                        chars[j] = c; // c가 될 수 있는 것은  a~z

                        String nextWord = new String(chars);

                        if (Arrays.asList(words).contains(nextWord) && !visited.contains(nextWord)) {
                            // 변환할 수 있는 단어가 있다면 큐에 추가하고 방문 처리
                            queue.offer(nextWord);
                            System.out.println("queue : " + queue);
                            visited.add(nextWord);
                            System.out.println("visited : " + visited);
                        }
                    }
                   // System.out.println();
                }

            }
            // 현재 단계의 변환 횟수 증가
            answer++;
        }

        return answer;
    }

}
