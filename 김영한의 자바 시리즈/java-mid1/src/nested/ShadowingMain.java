package nested;

// Shadowing: 스코프 상에서 다른 변수를 가려서 안보이게 함
public class ShadowingMain {
    private int value = 1;

    class Inner {
        private int value = 2; // 외부클래스 멤버변수와 같음

        void go() {
            int value = 3; // 내부/외부클래스 멤버변수와 같음

            // 제일 가까운 애는 뭐 안붙여도 알아봄
            System.out.println("value = " + value); // 3

            // 그냥 this -> 해당 메서드가 가장 가까이에 포함된 Inner 클래스를 가리킴
            System.out.println("this.value = " + this.value); // 2

            // 외부 클래스의 this 호출 -> 외부 클래스의 멤버변수 접근
            System.out.println("ShadowingMain.value = " + ShadowingMain.this.value); // 1

            // ..근데 이렇게 하지 말고 그냥 변수명을 다르게 쓰자. 명확성이 생명이다.
        }
    }

    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
