package getPermutation;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3,3));
    }
    public List<List<String>> getPermutation(int n, int k) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtrack(k, new ArrayList<>(), n, visited, ans);
        return ans;
    }


    private void backtrack(int r, List<String> curr, int nums, boolean[] visited, List<List<String>> ans) {
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums; i++) {
            if (visited[i]) continue;

            //curr.add();
            visited[i] = true;

            backtrack(r, curr, nums, visited, ans);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}