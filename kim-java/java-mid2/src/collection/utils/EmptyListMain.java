package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {
	public static void main(String[] args) {
		// 빈 리스트: 조회 결과가 0건이거나 null 반환하기 좀 그럴 때 사용
		// 빈 가변 리스트: 우리가 이미 사용중
		List<Integer> emptyMutableList = new ArrayList<>();

		// 빈 불변 리스트
		List<Integer> oldEmptyImmutableList = Collections.emptyList();
		List<Integer> emptyImmutableList = List.of(); // 이게 더 권장됨

		System.out.println(oldEmptyImmutableList.getClass()); // Collections.EmptyList
		System.out.println(emptyImmutableList.getClass()); // ImmutableCollections.List
	}
}
