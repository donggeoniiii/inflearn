package enumeration.test;

import java.util.Scanner;

public class AuthGradeMain2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        AuthGrade grade = AuthGrade.valueOf(input.nextLine().toUpperCase());

        grade.getLobby();
    }
}
