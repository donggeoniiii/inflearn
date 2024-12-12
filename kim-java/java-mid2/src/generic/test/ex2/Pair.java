package generic.test.ex2;

public class Pair<K, V> {
	private K first;
	private V second;

	public K getFirst() {
		return first;
	}

	public void setFirst(K first) {
		this.first = first;
	}

	public V getSecond() {
		return second;
	}

	public void setSecond(V second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair{" +
			"first=" + first +
			", second=" + second +
			'}';
	}
}
