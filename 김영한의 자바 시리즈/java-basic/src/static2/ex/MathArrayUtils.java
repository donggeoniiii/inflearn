package static2.ex;

public class MathArrayUtils {
	// 객체 생성 차단
	private MathArrayUtils() {
	}

	static int sum(int[] values) {
		int sum = 0;
		for (int value : values) {
			sum += value;
		}
		return sum;
	}

	static double average(int[] values) {
		return sum(values) / (double)values.length;
	}

	static int min(int[] values) {
		int min = values[0];
		for (int cur : values) {
			if (cur < min) {
				min = cur;
			}
		}
		return min;
	}

	static int max(int[] values) {
		int max = values[0];
		for (int cur : values) {
			if (cur > max) {
				max = cur;
			}
		}
		return max;
	}
}
