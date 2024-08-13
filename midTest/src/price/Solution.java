package price;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        // 모든 인덱스를 순회
        for(int i = 0; i < prices.length; i++) {
            // stack이 빌때까지 순회한다.
            while(!stack.isEmpty()){
                int top = stack.peek();
                // stack의 맨 위 인덱스의 가격이 현재 가격보다 큰지 확인
                if(prices[top] > prices[i]){
                    // 인덱스 간의 차이를 저장하고 스택 맨위 인덱스를 제거한다.
                    answer[top] = i - top;
                    System.out.println("top = " + top + ", curr = " + i);
                    System.out.println("stack = " + stack);
                    System.out.println( "answer : "+Arrays.toString(answer));
                    System.out.println();
                    stack.pop();
                }
                else break; // 아니라면 빠져 나온다.
            }
            stack.push(i);
        }

        // 스택에 남은 인덱스들에 대해서 기간을 계산하여 저장
        while (!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - 1 -index;
            System.out.println("stack = " + stack);
            System.out.println( "answer : "+Arrays.toString(answer));
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(new int[]{1,2,3,2,3});

        System.out.println( Arrays.toString(answer));
    }
}
