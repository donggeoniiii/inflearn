package class1;

public class ClassStart1 {
    public static void main(String[] args) {
        // 같은 코드가 계속 반복됨, 학생이 늘어날 때마다 낭비 심함
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;

        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 80;

        System.out.println("이름:" + student1Name + " 나이:" + student1Age + " 성적:" + student1Grade);
        System.out.println("이름:" + student2Name + " 나이:" + student2Age + " 성적:" + student2Grade);
    }
}
