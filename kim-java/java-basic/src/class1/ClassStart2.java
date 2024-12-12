package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        // 배열을 사용하는 경우, 데이터 변경시 매우 조심해야 함
        // 사람이 관리하기 좋은 코드는 아님
        String[] studentNames = {"학생1", "학생2", "학생3", "학생4"};
        int[] studentAges = {15, 16, 15, 17};
        int[] studentGrade = {90, 80, 60, 100};
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("이름: " + studentNames[i]);
            System.out.println("나이: " + studentAges[i]);
            System.out.println("성적: " + studentGrade[i]);
        }
    }
}
