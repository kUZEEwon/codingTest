package POJ_더맵게;
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

import java.util.PriorityQueue;


public class Solution {

    public int cal_scovile(int a, int b){
        int ans =0;
        ans = a +(b*2);
        return ans;
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;


        // PriorityQueue로 Min-Heap 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 배열 요소를 힙에 추가
        for (int num : scoville) {
            minHeap.add(num);
        }


        while(minHeap.peek() < K){

            int a= minHeap.poll();
            if( minHeap.isEmpty() ){
                answer=-1;
                break;
            }

            int b= minHeap.poll();

            int scovile = cal_scovile(a,b);
            minHeap.add(scovile);

            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println("답: "+solution.solution(scoville, K));
    }
}
