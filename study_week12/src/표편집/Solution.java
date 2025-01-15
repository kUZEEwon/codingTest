package 표편집;
// https://blog.encrypted.gg/1001?category=916869
/*
* 위 그림에서 파란색으로 칠해진 칸은 현재 선택된 행을 나타냅니다.
* 단, 한 번에 한 행만 선택할 수 있으며, 표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다.
* 이때, 다음과 같은 명령어를 이용하여 표를 편집합니다.

"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
예를 들어 위 표에서 "D 2"를 수행할 경우 아래 그림의 왼쪽처럼 4행이 선택되며, "C"를 수행하면 선택된 행을 삭제하고,
* 바로 아래 행이었던 "네오"가 적힌 행을 선택합니다(4행이 삭제되면서 아래 있던 행들이 하나씩 밀려 올라오고, 수정된 표에서 다시 4행을 선택하는 것과 동일합니다).*/

/*
* 풀이 방법
* 삭제된 행 : stack (가장 최근에 삭제된것이 반환 될수 있다)
* 커서가 돌아다니면서 중간에 삭제를 하는 형태임 => 연결 리스트가 필요함
* */
import java.util.*;
class Solution {

    final int MX = 1200005;
    int dat[] = new int[MX]; // 각 노드에 저장된 데이터
    int pre[] = new int[MX]; // 각 노드의 이전 주소
    int nxt[] = new int[MX]; // 각 노드의 다음 노드 주소
    int unused =1; // 다음으로 삽입할 데이터 주소

    int[] num2idx = new int[1000005]; // 수 i가 저장된 주소

    // addr번지 뒤에 num을 삽입, num을 삽입한 위치를 반환
    public int insert(int addr, int num){
        dat[unused] = num;      // 새로운 데이터 num 저장
        pre[unused] = addr;      // 새 노드의 이전 노드는 addr
        nxt[unused] = num2idx[addr];    // 새 노드의 다음 노드는 addr이 가리키던 노드
        if(nxt[addr] != -1) pre[nxt[addr]] = unused;  // 다음 노드가 존재하면 이전 노드를 새 노드로 갱신
        nxt[addr] = unused;         // addr의 다음 노드로 새 노드 설정
        return unused++;
    }
    public String solution(int n, int k, String[] cmd) {
        // n : 표의 행의 개수
        // k : 처음에 선택된 행의 위치

        String answer = "";
        dat[0] = nxt[0] = -1;

        for(int i=0; i<n; i++){
            num2idx[i] = insert(i,i);
        }
        int cursor = num2idx[k]; // 커서를 원소 k에 둠
        Stack<Pair> erased = new Stack<Pair>(); // 삭제 되는 원소들에 대해 (이전원소의 값, 현재 원소의 값) 저장

        for(int i=0; i<cmd.length; i++){
            if(cmd[i].charAt(0) == 'U'){
               
            }
        }
        return answer;
    }

    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}