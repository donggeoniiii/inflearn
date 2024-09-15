package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.getClass()); // ArrayList

		// 참고) 멀티스레드 동기화, 일반 리스트보다 성능은 느림(동기화 작업)
		List<Integer> syncList = Collections.synchronizedList(list);
		System.out.println(syncList.getClass()); // Collections.SynchronizedRandomAccessList
	}
}
