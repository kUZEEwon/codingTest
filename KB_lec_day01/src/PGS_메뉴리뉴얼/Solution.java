package PGS_메뉴리뉴얼;
import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> ans_list = new ArrayList<>();
        Map<String, Integer> comb_count ;

        for(int c : course){
            comb_count = new HashMap<>();

            for(String str : orders){
                String[] order = str.split("");
                Arrays.sort(order);
                comb(order, new StringBuilder(), 0, c, comb_count);
            }
            System.out.println("comb_count for course " + c + " : " + comb_count);
            int maxcnt = find_max(comb_count);//
            if(maxcnt >=2) {
                for(String key: comb_count.keySet()){
                    if(comb_count.get(key) == maxcnt){
                        ans_list.add(key);
                    }
                }
            }
        }

        answer = ans_list.toArray(new String[ans_list.size()]);
        Arrays.sort(answer);
        return answer;
    }

    private int find_max(Map<String, Integer> combCount) {
        int max_value=0;

        for(int cnt : combCount.values()){
            if(cnt > max_value){
                max_value=cnt;
            }
        }
        return max_value;
    }

    private void comb(String[] order, StringBuilder curr, int start, int size, Map<String, Integer> combCount) {
        if(curr.length() == size){
            combCount.put(curr.toString(), combCount.getOrDefault(curr.toString(), 0) + 1);
            return;
        }

        for(int i = start; i < order.length; i++){
            curr.append(order[i]);
            comb(order, curr, i + 1, size, combCount);
            curr.deleteCharAt(curr.length() - 1); // 지정된 문자를 삭제(가장 마지막 문자 삭제)
        }
    }


    public static void main(String[] args) {
        String[] orders = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = new int[] {2, 3, 4};
        Solution solution = new Solution();
        String[] answer = solution.solution(orders, course);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}