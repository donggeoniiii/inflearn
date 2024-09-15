package collection.iterable;

import java.util.*;

public class JavaIterableMain {
    public static void main(String[] args) {
        // Iterable/Iterator의 장점: 자료구조에 상관 없이 동일하게 순회 가능!
        // 객체 내부 표현 방식 안 보여줄 수 있음(캡슐화)
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        
        printAll(list.iterator()); // 1 2 3 
        printAll(set.iterator()); // 1 2 3
        
        forEach(list); // 1 2 3
        forEach(set); // 1 2 3
    }

    // 반복자(Iterator)만 있으면 다 사용 가능한 메서드
    private static void printAll(Iterator<Integer> iterator) {
        System.out.println(iterator.getClass()); // ArrayList.Itr, HashMap.KeyIterator(value 없는 hashmap == hashset)
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }
        System.out.println(sb);
    }

    // 반복 가능한 객체(Iterable)면 다 사용 가능한 메서드
    private static void forEach(Iterable<Integer> iterable) {
        System.out.println(iterable.getClass()); // ArrayList, HashSet
        StringBuilder sb = new StringBuilder();
        for (int cur : iterable) {
            sb.append(cur).append(" ");
        }
        System.out.println(sb);
    }
}