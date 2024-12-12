package nested.inner;

public class InnerOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    // 내부 클래스: 바깥 클래스의 인스턴스에 포함됨, 따라서 멤버변수에 접근 가능
    class Inner {
        private int innerInstanceValue = 1;

        public void print() {
            // 자기 자신에 접근: 당연히 가능
            System.out.println(innerInstanceValue); // 1

            // 외부 클래스의 인스턴스 멤버에 접근: private도 가능
            // 내부 클래스 인스턴스 생성시 외부 클래스 멤버 변수의 참조값을 갖고 있다
            System.out.println(outInstanceValue); // 2

            // 외부 클래스의 클래스 멤버에 접근: private도 가능
            System.out.println(outClassValue); // 3
        }
    }
}
