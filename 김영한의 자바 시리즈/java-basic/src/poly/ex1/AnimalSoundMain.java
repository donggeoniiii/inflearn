package poly.ex1;

public class AnimalSoundMain {
    public static void main(String[] args) {
        // 각각의 자식 클래스 변수 선언
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        // 다형적 참조: 부모는 자식을 모두 담을 수 있으므로 같은 배열에 담고 순회 가능
        Animal[] animals = {dog, cat, cow};
        for (Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    // 변하지 않을 부분은 메소드로 빼는 게 유지보수에 좋다
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        // 메서드 오버라이딩: 오버라이딩된 메서드가 우선권을 가진다
        animal.sound(); // 각 동물별 울음소리 실행
        System.out.println("동물 소리 테스트 종료");
    }
}
