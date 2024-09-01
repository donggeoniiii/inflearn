package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMain {
    public static void main(String[] args) throws Exception {
        // Class 조회
        Class clazz = String.class; // String 클래스 직접 정보 조회
        // Class clazz = new String().getClass(); // String 인스턴스에서 클래스 정보 조회
        //Class clazz = Class.forName("java.lang.String"); // 문자열로 조회

        // String 클래스의 모든 필드 출력
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getType() + " " + field.getName());
        }

        // String 클래스의 모든 메서드 출력
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // String 클래스의 상위 클래스 정보 출력
        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        // String 클래스의 인터페이스 정보 출력
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }

        // Class 인스턴스 생성
        //Class helloClass = Hello.class;
        Class helloClass = Class.forName("lang.clazz.Hello");

        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
        String result = hello.hello(); // 클래스 정보@참조값
        System.out.println("result = " + result); // hello!

        // 이렇게 메타데이터를 가지고 정보를 얻는 리플렉션은 그냥 알아만 두자
    }
}
