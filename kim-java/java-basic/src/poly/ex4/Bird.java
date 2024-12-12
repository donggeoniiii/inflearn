package poly.ex4;

// 인터페이스는 타 추상클래스 혹은 인터페이스와 다중 상속 가능
// 둘다 쓰는 경우 extends가 implements보다 먼저 온다
public class Bird extends AbstractAnimal implements Fly {
    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("새 날기");
    }
}
