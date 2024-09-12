package collection.set;

public class MyIntegerSetMain {

    public static void main(String[] args) {
        MyIntegerSet set = new MyIntegerSet(10);
        
        // 추가
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(14);
        set.add(99);
        set.add(9); // hashIndex 중복
        System.out.println(set); // [[], [1], [2], [], [14], [5], [], [], [8], [99, 9]]

        // 검색
        System.out.println(set.contains(9)); // true

        // 삭제
        boolean removeResult = set.remove(9);
        System.out.println(removeResult); // false
        System.out.println(set); // [[], [1], [2], [], [14], [5], [], [], [8], [99]]

        // 그럼 정수형 말고 다른 객체들은 어떻게 해시를 태우지..?
    }
}