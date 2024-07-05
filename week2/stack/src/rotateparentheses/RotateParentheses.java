package rotateparentheses;

import java.util.*;
public class RotateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "[](){}";
        System.out.println(solution.solution(input));
    }
}

class Solution {

    public int solution(String s) {
        // 문자열을 큐로 변환
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        int answer = 0;
        // rotate
        for (int i = 0; i < s.length(); i++) {
            // 현재 큐의 문자열을 생성
            StringBuilder rotatedString = new StringBuilder();
            for (char c : queue) {
                rotatedString.append(c);
            }

            // 유효성 검사
            if (isValid(rotatedString.toString())) {
                answer++;
            }

            // 큐 회전
            char firstElement = queue.poll();
            queue.add(firstElement);
        }

        return answer;
    }
    boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // 여는 괄호를 만나면 스택에 push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // 스택이 비어 있으면 매칭되는 여는 괄호가 없으므로 false 반환
                }
                char open = stack.pop(); // top에 있는 요소 빼내기
                if (!isMatchingPair(open, ch)) { // 닫힌 괄호랑 짝인지 아닌지 비교
                    return false; // 맞지 않는 괄호
                }
            }
        }

        // stack이 비어있으면 모든 괄호가 매칭된 것이므로 true
        return stack.isEmpty();
    }

    // 서로 다른 괄호들이 각각의 짝인지 확인
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}