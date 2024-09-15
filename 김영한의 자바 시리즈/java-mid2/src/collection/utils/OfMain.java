package collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {

    public static void main(String[] args) {
        // (컬렉션 종류).of(): 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3);
        Set<Integer> set = Set.of(1, 2, 3);
        Map<Integer, String> map = Map.of(1, "one", 2, "two");

        System.out.println(list); // [1, 2, 3]
        System.out.println(set); // [1, 2, 3]
        System.out.println(map); // {1=one, 2=two}
        System.out.println(list.getClass()); // ImmutableCollections.List

        // 내용 수정 안됨
        // list.add(4); // compile error: UnsupportedOperationException
    }
}