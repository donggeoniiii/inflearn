package poly.ex3;

public class InterfaceMain {
    public static void main(String[] args) {
        // 인터페이스 생성 불가
        // InterfaceAnimal interfaceAnimal = new InterfaceAnimal(); // compile error

        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        // 다형성 -> 한 배열에 담을 수 있음
        InterfaceAnimal[] animals = {cat, dog, cow};
        for (InterfaceAnimal animal : animals) {
            soundAnimal(animal);
        }
    }

    //변하지 않는 부분
    private static void soundAnimal(InterfaceAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

}
