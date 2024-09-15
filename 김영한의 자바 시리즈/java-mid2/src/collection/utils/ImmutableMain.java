package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        // 불변 리스트
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list); // [1, 2, 3]
        // list.add(4); // 얘는 안됨

        // 가변 리스트
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4); // 얘는 가능
        System.out.println(mutableList); // [1, 2, 3, 4]
        System.out.println(mutableList.getClass()); // ArrayList

        // unmodifiableXXX(): 불변 컬렉션 전환
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println(unmodifiableList.getClass()); // UnmodifiableRandomAccessList

        // 다시 추가 안됨
        // unmodifiableList.add(5); // compile error: UnsupportedOperationException

        // 참고) Arrays.asList(): 크기 불변, 수정은 가능
        List<Integer> asList = Arrays.asList(1, 2, 3);
        System.out.println(asList); // [1, 2, 3]
        asList.set(0, -1);
        // asList.add(4); // compile error: UnsupportedOperationException
        // asList.remove(-1); // compile error: UnsupportedOperationException
        System.out.println(asList); // [-1, 2, 3]
    }
}