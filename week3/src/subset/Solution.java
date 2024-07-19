package subset;
import java.util.*;
/*
* Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
* */
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input= {1,2,3};
        System.out.println(sol.subsets(input));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, ans);
        return ans;
    }
    private void backtrack(int start, List<Integer> path, int[] nums, List<List<Integer>> ans) {
        // 현재 부분집합 (path)을 결과 리스트에 추가
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {

            path.add(nums[i]);
            backtrack(i + 1, path, nums, ans);
            path.remove(path.size() - 1);
        }
    }
}
