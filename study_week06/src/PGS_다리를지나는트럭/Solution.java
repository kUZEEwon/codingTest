package PGS_다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length: 최대 다리 개수
        // weight: 무게 임계치

        int answer = 0; // 경과시간
        int current_truck_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        // 다리 위의 트럭 수만큼 큐에 0을 미리 채워넣어 놓습니다.
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0); // 다리의 공간을 0으로 채워놓기
        }
        System.out.println("Initial bridge state: " + bridge);

        for (int truck : truck_weights) {
            // 트럭이 다리 위로 올라가려면
            while (true) {
                // 다리에서 트럭이 빠져나가면
                int removedTruck = bridge.poll();
                current_truck_weight -= removedTruck;
                System.out.println("Removed truck with weight " + removedTruck + ", Current bridge state: " + bridge);

                // 새로운 트럭이 올라갈 수 있으면
                if (current_truck_weight + truck <= weight) {
                    bridge.offer(truck); // 트럭을 다리에 올린다
                    current_truck_weight += truck; // 다리 위의 무게 갱신
                    answer++; // 시간이 1초 흐른다
                    System.out.println("Truck with weight " + truck + " enters the bridge. Time: " + answer);
                    System.out.println("Current bridge state: " + bridge);
                    break;
                } else {
                    // 올라갈 수 없으면 대기
                    bridge.offer(0); // 대기 중인 트럭을 다리에 추가
                    answer++; // 시간이 1초 흐른다
                    System.out.println("No truck enters, 0 added to bridge. Time: " + answer);
                    System.out.println("Current bridge state: " + bridge);
                }
            }
        }

        // 모든 트럭이 다리를 건넜을 때 남은 시간은 다리 길이만큼
        System.out.println("Final bridge state: " + bridge);
        return answer + bridge_length;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예시 테스트 케이스 1
        int bridgeLength1 = 2;
        int weight1 = 10;
        int[] truckWeights1 = {7, 4, 5, 6};
        int result1 = solution.solution(bridgeLength1, weight1, truckWeights1);
        System.out.println("Test Case 1 Result: " + result1); // 출력: 8

        // 예시 테스트 케이스 2
        int bridgeLength2 = 100;
        int weight2 = 100;
        int[] truckWeights2 = {10};
        int result2 = solution.solution(bridgeLength2, weight2, truckWeights2);
        System.out.println("Test Case 2 Result: " + result2); // 출력: 101

        // 예시 테스트 케이스 3
        int bridgeLength3 = 100;
        int weight3 = 100;
        int[] truckWeights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int result3 = solution.solution(bridgeLength3, weight3, truckWeights3);
        System.out.println("Test Case 3 Result: " + result3); // 출력: 110
    }
}