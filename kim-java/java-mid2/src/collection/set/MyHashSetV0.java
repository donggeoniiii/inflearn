package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

	private int[] elements = new int[10];
	private int size = 0;

	public int size() { return size; }

	public boolean add(int value) {
		// 이미 넣은거면 추가 안함
		if (contains(value)) {
			return false;
		}
		
		elements[size++] = value;
		return true;
	}

	public boolean contains(int value) {
		for (int element : elements) {
			if (value == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elements, size));
	}
}
