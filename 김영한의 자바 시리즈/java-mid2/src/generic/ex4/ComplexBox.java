package generic.ex4;

import generic.animal.Animal;

// 제네릭 타입 내에서 제네릭 메서드 사용도 당연히 가능
public class ComplexBox<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    // 제네릭 타입 내 제네릭 메서드가 있으면 가까운 메서드의 타입 매개변수를 따라감
    // 그래서 이렇게 쓸거면 그냥 타입 매개변수를 다르게 표현하는 편이 좋다
    public <T1 /*extends Animal*/> T1 printAndReturn(T1 t) {
        System.out.println("animal.className: " + animal.getClass().getName());
        System.out.println("t.className: " + t.getClass().getName());
        // 제네릭 메서드는 <T extends Animal> 타입이 아니므로 Animal 하위에 있는 메서드 사용 불가.
        // t.getName(); -> compile error
        return t;
    }

}