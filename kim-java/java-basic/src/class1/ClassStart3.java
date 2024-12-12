package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        // Student 타입을 담을 수 있는 변수, 객체의 참조값 보관
        Student student1;
        // System.out.println(student1); -> packageName.ClassName@ref

        // 객체: 설계도인 클래스를 사용해 메모리에 올라간 실체, 각각의 객체는 독립적임
        student1 = new Student();

        // . 키워드 -> 참조값을 통해 해당하는 실제 객체에 접근
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        // 객체와 인스턴스는 거의 동의어, 인스턴스는 특정 클래스의 객체임을 강조할 때 씀
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;

        System.out.println("이름: " + student1.name + " 나이: " + student1.age + " 성적: " + student1.grade);
        System.out.println("이름: " + student2.name + " 나이: " + student2.age + " 성적: " + student2.grade);
    }
}
