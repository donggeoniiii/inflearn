package poly.ex3;

// 인터페이스는 implements 키워드로 "구현"함
// 상속이라고 표현하기엔 부모가 주는게 없어서 구현이라고 표현(java는 똑같이 봄)
public class Cat implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("냐옹");
    }

    @Override
    public void move() {
        System.out.println("고양이 이동");
    }
}
