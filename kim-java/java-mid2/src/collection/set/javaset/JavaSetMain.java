package collection.set.javaset;

import java.util.*;

public class JavaSetMain {

    public static void main(String[] args) {
        run(new HashSet<>()); // 순서 보장x
        run(new LinkedHashSet<>()); // 순서 보장
        run(new TreeSet<>()); // 순서 보장x, 대신 값 정렬
    }

    private static void run(Set<String> set) {
        System.out.println(set.getClass());
        set.add("C");
        set.add("B");
        set.add("A");
        set.add("1");
        set.add("2");

		for (String s : set) {
			System.out.print(s + " ");
		}
        System.out.println();
    }
}