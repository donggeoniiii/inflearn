package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {
    // 하한 설정: 와일드카드는 클래스의 하한 설정도 가능하다
    static void writeBox(Box<? super Animal> box) { // Animal 이상의 상위 클래스만 가능
        box.set(new Dog("멍멍이", 100));
    }

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        // Animal 포함 상위 타입 전달 가능
        writeBox(objBox);
        writeBox(animalBox);
        // writeBox(dogBox); // compile error: 하한이 Animal
        // writeBox(catBox); // compile error: 하한이 Animal

        Animal animal = animalBox.get();
        System.out.println("animal = " + animal);
    }
}