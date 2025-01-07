package BOJ_가운데를말해요;

import java.util.*;
import java.io.*;

public class Main {
    public static int cal_middle(PriorityQueue<Integer> pq) {
        // 우선순위 큐를 리스트로 변환하여 정렬된 상태를 유지
        List<Integer> sortedList = new ArrayList<>(pq);

        // 정렬
        Collections.sort(sortedList);

        // 중간값 계산
        int size = sortedList.size();
        if (size % 2 == 0) {
            // 짝수일 경우
            return sortedList.get(size / 2 - 1) ;
        } else {
            // 홀수일 경우
            return sortedList.get(size / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
//            System.out.println(cal_middle(pq));
            // 중간값 계산 및 출력
            bw.write(String.valueOf(cal_middle(pq))); // 정수를 문자열로 변환
            bw.newLine(); // 줄바꿈 추가
        }
        // 출력 버퍼 비우기
        bw.flush();
        bw.close();
    }

}
