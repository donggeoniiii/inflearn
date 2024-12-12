package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent {

    public void call() {
        // public: 접근 가능
        publicValue = 1;
        publicMethod();

        // protected: 다른 패키지지만 상속 관계라 접근 가능
        protectedValue = 1;
        protectedMethod();

        // default(package-private): 다른 패키지라 접근 불가
        // defaultValue = 1; // compile error
        // defaultMethod(); // compile error

        // private: 접근 불가
        // privateValue = 1; // compile error
        // privateMethod(); // compile error

        // 메서드 자체는 public이므로 호출가능
        // 이후는 부모 클래스로 넘어가서 실행되므로 정상 실행
        printParent();
    }
}
