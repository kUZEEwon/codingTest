package BOJ_14891;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static List<int[]> gears;
    public static void main(String[] args) {
        // temp 배열 초기화
        gears= new ArrayList<int[]>();
        gears.add(new int[]{1, 0, 1, 0, 1, 1, 1, 1});
        gears.add(new int[]{0, 1, 1, 1, 1, 1, 0, 1});
        gears.add(new int[]{1, 1, 0, 0, 1, 1, 1, 0});
        gears.add(new int[]{0, 0, 0, 0, 0, 0, 1, 0});

        System.out.println("before : " + Arrays.toString(gears.get(2)));
        declock(2);
        System.out.println("after : " + Arrays.toString(gears.get(2)));
    }

    public static void declock(int start){
        // 왼쪽으로 1칸 밀기
        int size = gears.get(0).length;
        int first = gears.get(start)[0];

        for(int i = 0; i <size-1 ; i++){
            gears.get(start)[i] = gears.get(start)[i+1];
        }
        gears.get(start)[size - 1] = first;
    }
}
