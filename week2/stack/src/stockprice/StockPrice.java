package stockprice;

/*
https://campus.programmers.co.kr/tryouts/139163/challenges?language=java
문제 설명
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
입출력 예
prices	        return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
입출력 예 설명
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
* */

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution.solution(prices)));

    }
}


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // Stack 이용해서 풀기
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        // 스택에 남아있는 인덱스들은 가격이 끝까지 떨어지지 않은 것들
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        /*
        // Arrays.fill 메서드를 사용하여 배열의 모든 값을 0으로 설정
        Arrays.fill(answer, 0);

        int currentindex = 0;
        int currentcost = prices[0];
        while(currentindex < prices.length-1) {
            for(int i = currentindex+1; i < prices.length; i++) {
                if(currentcost <= prices[i]) {
                    int index = i;
                    answer[currentindex]++;
                }else{
                    answer[currentindex]++;
                    break;
                }
            }
            currentindex++;
            currentcost = prices[currentindex];
        }*/



        return answer;
    }
}