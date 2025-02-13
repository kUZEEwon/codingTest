package PGS_문자열압축;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        int s_len = s.length();

        // 1개 단위(step) 부터 압축 단위를 늘려가며 확인
        for (int step = 0; step < s_len /2; step++) {

            int count = 1;
            String prev = s.substring(0, step);
            for (int i = step; i < s_len; i = i + step) {
                String curr = s.substring(i, i + step);
            }
        }
        return answer;
    }
}