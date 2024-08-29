package poly.ex2;

// 추상 클래스: 추상적인 개념만 제공, 실체(인스턴스) 존재 x
public abstract class AbstractAnimal {

    // 추상 메소드, 하나라도 있으면 해당 클래스는 추상 클래스여야 함(직접 사용되지 않도록)
    // 오버라이드 강제됨(안하면 컴파일 에러)
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
