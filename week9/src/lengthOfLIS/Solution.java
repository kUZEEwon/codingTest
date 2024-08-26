package lengthOfLIS;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {10,9,2,5,3,7,101,18};
        int[] nums2 = {0,1,0,3,2,3};
        int[] nums3 = {7,7,7,7,7,7,7,7};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums3));
    }


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // 모든 원소의 dp 값을 1로 초기화

        int maxLength = 1;  // LIS의 최대 길이 초기화

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // 증가하는 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // dp 값 갱신
                }
            }
            // 갱신된 dp 배열을 출력
            System.out.println("i = " + i + ", nums[i] = " + nums[i] + ", dp: " + Arrays.toString(dp));
            maxLength = Math.max(maxLength, dp[i]);  // 최종 LIS 길이 갱신
        }
        System.out.println("dp = " + Arrays.toString(dp));
        return maxLength;
    }
}
