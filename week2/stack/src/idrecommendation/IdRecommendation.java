
/*
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다*/
package idrecommendation;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

public class IdRecommendation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input =  "abcdefghijklmn.p";
        String output = solution.solution(input);
        System.out.println(output);
    }
}


class Solution {
    public String solution(String new_id) {
        // step 1 모두 소문자로 변경하기
        String id = new_id.toLowerCase();

        // step 2 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuilder sb = new StringBuilder();
        for (char c : id.toCharArray()) {
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        String cleanedId = sb.toString();

        // step 3 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String answer = cleanConsecutiveDots(cleanedId);

        // step 4 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // 시작이나 끝에 위치한 마침표 제거
        if(answer.startsWith(".")){
            answer = answer.substring(1); // index 1 부터 가져와라
        }
        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length()-1); // substring(start, end) : start에서 end 이전 원소까지 반환
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer.isEmpty()){
            answer="a";
        }

        // step 6 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length() >= 16){
            answer=answer.substring(0,15);
            if(answer.endsWith(".")){
                answer=answer.substring(0,answer.length()-1);
            }
        }

        // step7 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
        if(answer.length() <3 ){
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }


        return answer;
    }

    public static String cleanConsecutiveDots(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for(char c : s.toCharArray()){
            if(c == '.'){
                if(!flag){
                    sb.append(c);
                    flag = true;
                }
            }
            else{
                sb.append(c);
                flag = false;
            }
        }

        return sb.toString();
    }
}