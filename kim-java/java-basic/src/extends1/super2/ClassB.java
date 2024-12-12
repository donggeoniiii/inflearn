package extends1.super2;

public class ClassB extends ClassA {
    public ClassB(int a) {
        this(a, 0); // 밑에 있는 생성자에 super가 있으므로 한번은 호출됨
        System.out.println("ClassB 생성자 a = " + a);
    }

    // 생성자 오버로딩
    public ClassB(int a, int b) {
        super(); // 부모클래스의 생성자가 기본 생성자 -> 생략 가능
        System.out.println("ClassB 생성자 a = " + a + " b = " + b);
    }
}
