package keysandrooms;
// https://leetcode.com/problems/keys-and-rooms/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );
        boolean result = sol.canVisitAllRooms(rooms);
        System.out.println(result);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>(); // 방문한 노드
        Queue<Integer> queue = new LinkedList<>(); // 방문할 방을 추적

        // Start with room 0
        visited.add(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            // queue가 비어있지 않으면 진입
            int currentRoom = queue.poll(); // poll : Queue의 최상위 요소(헤드)를 검색하고 제거
            System.out.println("current room: " + currentRoom);
            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    // key에 방문한적이 없다면
                    // 다음 들어갈 곳 예약
                    visited.add(key);
                    System.out.println("visiting room " + visited);
                    queue.add(key);
                    System.out.println("adding key " + queue);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
