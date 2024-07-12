package combination;
import java.util.*;

public class Combinations {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.combine(4,2));
    }
}
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /*List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentcomb = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        comb(result, currentcomb, arr, 0, n, k);
        return result;*/

        //backtarack
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, result,new ArrayList<>(),n,k);
        return result;

    }
    void backtrack(int start,List<List<Integer>> result,List<Integer> curr,int n, int k){
        // basecase
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }


        // 재귀 호출
        for (int i=start ; i<=n ;i++){
            curr.add(i);
            backtrack(i+1,result,curr,n,k);
            curr.remove(curr.size()-1);
        }
    }

    public void comb(List<List<Integer>> result, List<Integer> currentcomb, int[] arr, int depth, int n, int r) {
        if (r == 0) {
            result.add(new ArrayList<>(currentcomb));
            return;
        }

        if (depth == n) {
            return;
        }

        // 현재 depth의 요소를 추가하는 경우
        currentcomb.add(arr[depth]);
        comb(result, currentcomb, arr, depth + 1, n, r - 1);
        currentcomb.remove(currentcomb.size() - 1);

        // 현재 depth의 요소를 추가하지 않는 경우
        comb(result, currentcomb, arr, depth + 1, n, r);
    }
}