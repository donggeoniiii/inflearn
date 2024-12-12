package nested.nested;

public class NestedOuter {

    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    // static으로 내부에 클래스 생성: 정적 중첩 클래스
    // 외부 클래스랑 남남임 그냥 같이 있는 것뿐
    static class Nested {
        private int nestedInstanceValue = 1;

        public void print() {
            // 자신의 멤버에 접근: 당연히 가능
            System.out.println(nestedInstanceValue); // 1

            // 외부 클래스의 인스턴스 멤버에 접근에는 접근불가(static은 인스턴스를 알 수 없음)
            // System.out.println(outInstanceValue);

            // 외부 클래스의 클래스 멤버에 접근: 같은 클래스 내부에 있어 private 이어도 가능
            System.out.println(NestedOuter.outClassValue); // 3
        }
    }
}
