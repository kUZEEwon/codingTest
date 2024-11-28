package boj_LCS;
import java.util.*;
import java.io.*;
// 20 min


public class Main {
    public static void main(String[] args) throws IOException {
        // 두 수열이 주어졌을 때 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 문자열 입력
        String str1  = br.readLine();
        String str2  = br.readLine();


        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

        br.close();
    }
}
