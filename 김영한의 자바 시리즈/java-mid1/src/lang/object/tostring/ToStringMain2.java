package lang.object.tostring;

public class ToStringMain2 {
    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        // 객체에서 그냥 toString()을 호출하면 정보가 맛이 없다
        System.out.println("1. 단순 toString 호출");
        System.out.println(car.toString()); // toString() 기본 반환값
        System.out.println(dog1.toString()); // toString() 기본 반환값
        System.out.println(dog2.toString()); // toString() 기본 반환값

        // 메서드 오버라이드를 통해 의미있는 정보로 변환
        System.out.println("2. println 내부에서 toString 호출");
        System.out.println(car); // toString() 재정의 안함, toString() 기본 반환값
        System.out.println(dog1); // Dog{dogName='멍멍이1', age=2}
        System.out.println(dog2); // Dog{dogName='멍멍이2', age=5}

        // 프린터 클래스를 만들어 상속받게 하기
        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.print(car); // 객체 정보 출력: toString() 기본 반환값
        ObjectPrinter.print(dog1); // 객체 정보 출력: Dog{dogName='멍멍이1', age=2}
        ObjectPrinter.print(dog2); // 객체 정보 출력: Dog{dogName='멍멍이2', age=5}

        // @ 뒤에 붙는 참조값만 보기
        String refValue = Integer.toHexString(System.identityHashCode(car));
        System.out.println("refValue = " + refValue); // 위의 Car 객체 toString 참조값과 동일
    }
}
