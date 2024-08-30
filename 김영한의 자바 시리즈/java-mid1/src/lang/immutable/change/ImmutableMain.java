package lang.immutable.change;

public class ImmutableMain {

    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        obj1.add(30); // 리턴값 사용 안함 -> 반환된 결과는 없어짐
        ImmutableObj obj2 = obj1.add(20);

        // 계산 이후에도 기존값과 신규값 모두 확인 가능
        System.out.println("obj1 = " + obj1.getValue()); // 10
        System.out.println("obj2 = " + obj2.getValue()); // 30
    }
}
