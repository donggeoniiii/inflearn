package generic.ex3;

import generic.animal.Animal;

// 타입 매개변수 제한: Animal을 상속하는 타입들만 들어올 수 있음
public class AnimalHospital<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }

}