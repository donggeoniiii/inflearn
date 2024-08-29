package static2;

public class DecoMain {

    public static void main(String[] args) {
        String s = "hello java";

        // 인스턴스 메서드: 객체를 통해서 메서드 호출
        DecoUtil1 utils = new DecoUtil1();
        String deco1 = utils.deco(s);

        System.out.println("before: " + s);
        System.out.println("after deco1: " + deco1); // *hello java*

        // 클래스(static) 메서드: 객체 생성 없이 바로 메서드 사용
        String deco2 = DecoUtil2.deco(s);

        System.out.println("after deco2: " + deco2); // *hello java*
    }
}
