/*
*
예시 1:

    입력: 온도 = [73,74,75,71,69,72,76,73]
     출력: [1,1,4,2,1,1,0,0]

예시 2:

    입력: 온도 = [30,40,50,60]
     출력: [1,1,1,0]

예시 3:

    입력: 온도 = [30,60,90]
     출력: [1,1,0]
* */
package dailytemperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        int arr[] = {73,74,75,71,69,72,76,73};
        Solution cls = new Solution();

        System.out.println(Arrays.toString(cls.dailyTemperatures(arr)));

    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        for(int day=0;day<temperatures.length; day++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[day]){
                int prevDay = stack.pop();
                answer[prevDay]= day-prevDay;
            }
            stack.push(day);
        }



        return answer;
    }
}