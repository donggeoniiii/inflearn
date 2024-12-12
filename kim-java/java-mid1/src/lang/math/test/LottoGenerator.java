package lang.math.test;

import java.util.Random;

public abstract class LottoGenerator {
	public static int[] generate() {
		int[] result = new int[6];
		boolean[] selected = new boolean[46];

		Random random = new Random();

		int idx = 0;
		while (idx < 6) {
			int curNum = random.nextInt(45) + 1;

			// 중복이면 다시 뽑음
			if (selected[curNum]) continue;

			// 중복이 아니면 선택하고 다음으로
			selected[curNum] = true;
			result[idx++] = curNum;
		}

		return result;
	}
}
