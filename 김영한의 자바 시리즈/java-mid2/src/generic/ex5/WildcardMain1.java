package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printWildcardV1(dogBox); // ? = 멍멍이 정보
        WildcardEx.printWildcardV2(dogBox); // 멍멍이

        // 와일드카드는 전달하는 값을 명확하게 할 수 없음(제네릭처럼 메서드 호출시 확정이 안됨)
        // compile error: Animal 이하 클래스를 받아 Animal로 반환할 뿐 멍멍이인지 냐옹이인지 모름
        // Dog animal = WildcardEx.printAndReturnWildcard(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox); // 멍멍이
    }

}