package poly.ex4;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog(); // 동물이면서 못 남
        Bird bird = new Bird(); // 동물이면서 날 수 있음
        Chicken chicken = new Chicken(); // 동물이면서 못 남

        // 동물들끼리 같은 배열에 담을 수 있음(같은 추상클래스 상속)
        AbstractAnimal[] animals = {dog, bird, chicken};
        for (AbstractAnimal animal : animals) {
            soundAnimal(animal);
        }

        // 날아 다니는 동물들은 인터페이스에서 구현한 메서드 사용 가능
        flyAnimal(bird);
        flyAnimal(chicken);
    }

    // AbstractAnimal 상속 클래스 사용 가능
    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

    // Fly 구현 클래스 사용 가능
    private static void flyAnimal(Fly fly) {
        System.out.println("날기 테스트 시작");
        fly.fly();
        System.out.println("날기 테스트 종료");
    }
}
