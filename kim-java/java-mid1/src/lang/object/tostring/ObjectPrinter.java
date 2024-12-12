package lang.object.tostring;

// 메소드만 제공하는 추상 클래스
public abstract class ObjectPrinter {
    // 최상위 클래스의 다형성을 활용해 모든 객체에 대해 적용 가능
    public static void print(Object obj) {
        String string = "객체 정보 출력: " + obj.toString();
        System.out.println(string);
    }

    /*
    다형성을 잘 활용한다 -> 다형적 참조와 메서드 오버라이딩을 적절하게 활용했다
    해당 print 메서드는
    1. 입력받는 값이 어떤 객체에 의존하지 않고(추상적임)
    2. 실행시에는 각 객체가 재정의한 toString() 결과를 활용한다(메서드 오버라이딩 활용)
    따라서 아주 다형성을 잘 활용한 케이스라 볼 수 있다!
     */
}
