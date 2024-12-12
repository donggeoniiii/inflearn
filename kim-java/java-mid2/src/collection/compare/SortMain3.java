package collection.compare;

import java.util.*;

public class SortMain3 {

    public static void main(String[] args) {
        MyUser a = new MyUser("a", 30);
        MyUser b = new MyUser("b", 20);
        MyUser c = new MyUser("c", 10);

        List<MyUser> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list); // [a, b, c]

        // Collections.sort(Comparator<>): Arrays.sort()와 동일한 역할
        Collections.sort(list);
        list.sort(null); // 위보다 더 권장되는 방식, 결과는 같음
        System.out.println(list); // [c, b, a]

        Collections.sort(list, new IdComparator());
        list.sort(new IdComparator()); // 위보다 더 권장되는 방식, 결과는 같음
        System.out.println(list); // [a, b, c]
    }

}