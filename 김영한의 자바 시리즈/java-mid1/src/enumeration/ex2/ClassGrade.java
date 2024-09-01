package enumeration.ex2;

// 타입 열거형 패턴
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    // 인스턴스 생성 제한
    private ClassGrade() {}
}
