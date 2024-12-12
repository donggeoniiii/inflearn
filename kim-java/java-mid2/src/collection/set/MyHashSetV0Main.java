package collection.set;

public class MyHashSetV0Main {
    public static void main(String[] args) {
        // 추가 -> O(n), 중복 확인과정이 오래 걸려서 성능 별로 안 좋음
        MyHashSetV0 set = new MyHashSetV0();
        set.add(1); // 처음은 O(1)
        set.add(2); // O(n)
        set.add(3); // O(n)
        set.add(4); // O(n)
        System.out.println(set); // [1, 2, 3, 4]

        // 중복 데이터를 저장하려고 하면 false 반환
        boolean result = set.add(4);
        System.out.println(result); // false
        System.out.println(set); // [1, 2, 3, 4]

        // 검색 -> O(n), 다 돌아봐야 해서 성능 별로 안 좋음
        System.out.println(set.contains(3)); // true
        System.out.println(set.contains(99)); // false
    }
}