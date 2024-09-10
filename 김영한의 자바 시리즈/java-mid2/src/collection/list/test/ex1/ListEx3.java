package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int n = input.nextInt();

            if (n == 0) {
                break;
            }

            numbers.add(n);
        }

        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        double avg = (double) total / numbers.size();
        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + avg);
    }
}