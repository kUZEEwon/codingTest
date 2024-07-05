
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

    }
}


class Solution {
    public String solution(String new_id) {
        String answer = "";

        // step 1 모두 소문자로 변경하기
        new_id.toLowerCase();

        // step 2 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        Pattern pattern = Pattern.compile("[^a-z0-9-_.]");
        Matcher matcher = pattern.matcher(new_id);
        new_id = matcher.replaceAll("");

        // step 3 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String replaced = cleanConsecutiveDots(new_id);

        // step 4 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // 시작이나 끝에 위치한 마침표 제거
        replaced = replaced.replaceAll("^\\.", ""); // 문자열 시작 부분의 마침표 제거
        replaced = replaced.replaceAll("\\.$", ""); // 문자열 끝 부분의 마침표 제거

        return answer;
    }

    public static String cleanConsecutiveDots(String s) {
        // 정규 표현식을 사용하여 연속된 마침표를 하나의 마침표로 대체
        String cleaned = s.replaceAll("\\.{2,}", ".");
        return cleaned;
    }
}