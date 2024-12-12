package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int n = input.nextInt();

            if (n == 0) {
                break;
            }

            numbers.add(n);
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            // 마지막이 아니면 쉼표 추가
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        System.out.println(sb);

    }
}