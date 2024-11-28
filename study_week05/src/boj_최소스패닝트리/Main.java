package boj_최소스패닝트리;
import java.util.*;
import java.io.*;

// 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
// 정점의 개수가 n이면 간선의 개수는 n-1


/* 크루스칼 알고리즘
1. 선택되지 않은 간선들 중 최소 가중치인 간선 선택
2. 만약 그 간선을 선택했을 때, 지금까지 구성된 스패닝 트리에 사이클이 없을 경우에만 선택
3. 총 v-1(정점의 개수-1)개의 간선이 선택될 때 까지 반복

구성한 스패닝 트리에 사이클이 발생하는지에 대한 여부를 판단하기 위해, 분리 집합(Disjoint Set)을 사용
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.close();
    }
}
