package Thief;
/*
* [1, 2, 3, 1]	4
[2, 7, 9, 3, 1]	12
* */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = { 1, 2, 3, 1 };
        int[] arr2 = {2, 7, 9, 3, 1 };
        System.out.println(s.solution(arr1));
        System.out.println(s.solution(arr2));
    }

    public int solution(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;
        if(n==1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];

        if(n > 1) dp[1] = Math.max(nums[0], nums[1]);



        // 부터가 문제임
        for(int i=2; i<n ;i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
            System.out.println("dp["+i+"]="+dp[i]);
        }


        return dp[n-1];
    }
}