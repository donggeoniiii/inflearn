package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMain {

    public static void main(String[] args) {
        AnimalHospital<Dog> dogHospital = new AnimalHospital<>();
        AnimalHospital<Cat> catHospital = new AnimalHospital<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup(); // 멍멍이1 정보

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup(); // 냐옹이1 정보

        // 개 병원에 고양이 전달
        // dogHospital.set(cat); // compile error: 타입 안 맞음

        dogHospital.set(dog);
        Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog); // 멍멍이2 정보
    }
}