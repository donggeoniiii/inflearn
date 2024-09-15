package collection.utils;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSortMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 5; i >= 1; i--) {
            list.add(i);
        }

        // 최대 최소 반환
        System.out.println(Collections.max(list)); // 5
        System.out.println(Collections.min(list)); // 1

        System.out.println(list); // [5, 4, 3, 2, 1]

        // 컬렉션 정렬
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3, 4, 5]

        // 무작위 셔플
        Collections.shuffle(list);
        System.out.println(list); // 랜덤 결과(재생할 때마다 다름)

        // 현재 상태에서 순서 뒤집기
        Collections.reverse(list);
        System.out.println(list);
    }
}