package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

// Stack 클래스는 사용하면 안됨(안에서 사용하는 Vector가 오래된 버전임)
public class DequeStackMain {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        // 데이터 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // 꺼내질 순서대로 정렬
        System.out.println(stack); // [3, 2, 1]

        // 다음에 꺼낼 데이터 조회
        System.out.println(stack.peek()); // 3

        // 데이터 꺼내기
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.isEmpty()); // true
    }
}