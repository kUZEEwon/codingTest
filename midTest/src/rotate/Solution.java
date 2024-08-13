package rotate;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer =  0;

        String sb = s + s;

        for (int i = 0; i < s.length(); i++) {
            if(isValid(sb.substring(i, s.length()+i))) answer++;
        }

        return answer;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char curr : str.toCharArray()) {
            if(curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else{
                if(stack.isEmpty()) return false;

                char target = stack.pop();
                if((curr != ')' && target == '(') ||
                (curr != '}' && target == '{') ||
                (curr != ']' && target == '[')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
