package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
	private Deque<String> history = new ArrayDeque<>();

	public void visitPage(String url) {
		System.out.println("방문: " + url);
		history.push(url);
	}

	public String goBack() {
		history.pop();
		System.out.println("뒤로 가기: " + history.peek());
		return history.peek();
	}
}
