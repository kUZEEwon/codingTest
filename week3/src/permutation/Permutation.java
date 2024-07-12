package permutation;


import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] input = {1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.permute(input));
    }

}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 결과를 저장할 리스트를 초기화
        List<List<Integer>> result = new ArrayList<>();
        // 현재 순열을 저장할 리스트를 초기화
        List<Integer> currentPermutation = new ArrayList<>();
        // 각 요소의 사용 여부를 추적할 배열을 초기화
        boolean[] used = new boolean[nums.length];
        // 백트래킹 함수 호출
        backtrack(nums, used, currentPermutation, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        // 기본 조건: 현재 순열의 크기가 주어진 배열의 크기와 같을 때
        if (currentPermutation.size() == nums.length) {
            // 완성된 순열을 결과 리스트에 추가
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // 배열의 각 요소를 탐색
        for (int i = 0; i < nums.length; i++) {
            // 이미 사용된 요소는 건너뛴다
            if (used[i]) {
                continue;
            }
            // 요소를 사용 중으로 표시
            used[i] = true;
            // 현재 순열에 요소를 추가
            currentPermutation.add(nums[i]);
            // 재귀적으로 백트래킹 함수 호출
            backtrack(nums, used, currentPermutation, result);
            // 재귀 호출 후 마지막 요소 제거 (백트래킹)
            currentPermutation.remove(currentPermutation.size() - 1);
            // 요소를 사용하지 않은 상태로 되돌림
            used[i] = false;
        }
    }
}