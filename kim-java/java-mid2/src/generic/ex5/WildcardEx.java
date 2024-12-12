package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {
    /*
        와일드카드(?로 정의): 모든 타입에 대응됨
        제네릭 메서드가 아니라 일반 메서드(반환값 앞에 <>안붙음)
        이미 만들어진 제네릭 타입을 활용하는 용도
        꼭 제네릭 타입이나 메서드를 써야되는 게 아니라면(ex: 특정 시점에 타입 전달해야 함)
        기존에 만들어진 제네릭 타입에 와일드카드를 권장하는 편
     */
    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    // 타입 매개변수 제한도 가능
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}