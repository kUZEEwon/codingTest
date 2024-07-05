// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "(())()";
        Solution cls = new Solution();
        System.out.println(cls.solution(str));

    }
}


class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // 문자열의 각 문자를 처리
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호에 대응되는 여는 괄호가 없음(아직 닫힌 괄호는 stack에 없다)
                }
                stack.pop(); // 여는 괄호 하나 제거
            }
        }

        // 스택이 비어있으면 모든 괄호가 짝을 맞춘 상태임
        return stack.isEmpty();
    }
}

// for 반복문을 돌려서 문자 하나하나에 접근한다
    // 열린 괄호면
        // stack에 넣기
    // 닫힌 괄호면
        // stack pop 하기