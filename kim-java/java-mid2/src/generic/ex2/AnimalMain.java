package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog findDog = dogBox.get();
        System.out.println("findDog = " + findDog); // 강아지 정보

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        Cat findCat = catBox.get();
        System.out.println("findCat = " + findCat); // 냐옹이 정보

        // 제네릭 클래스 + 상속을 이용해서 한번에 담기 가능
        Box<Animal> animalBox = new Box<>();
        animalBox.set(dog); // Animal = Dog
        animalBox.set(cat); // Animal = Cat
        Animal findAnimal = animalBox.get();
        System.out.println("findAnimal = " + findAnimal); // 냐옹이 정보
    }
}