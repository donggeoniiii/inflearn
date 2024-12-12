package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 100);

        // 제네릭 메서드(타입 추론)
        AnimalMethod.checkup(dog); // 멍멍이 정보
        AnimalMethod.checkup(cat); // 냐옹이 정보

        Dog targetDog = new Dog("큰 멍멍이", 200);
        Dog bigger = AnimalMethod.getBigger(dog, targetDog);
        System.out.println("bigger = " + bigger); // 큰 멍멍이 정보
    }
}