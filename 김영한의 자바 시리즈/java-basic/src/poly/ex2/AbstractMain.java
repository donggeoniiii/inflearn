package poly.ex2;

public class AbstractMain {
    public static void main(String[] args) {
        // 추상클래스는 인스턴스 생성 불가
        // AbstractAnimal animal = new AbstractAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        Duck duck = new Duck();

        cat.sound(); // 냐옹
        cat.move(); // 동물이 움직입니다.

        AbstractAnimal[] animals = {dog, cat, cow, duck};
        for (AbstractAnimal animal : animals) {
            soundAnimal(animal);
        }
    }

    // 변하지 않는 부분
    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

}
