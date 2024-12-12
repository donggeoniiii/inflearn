package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitPrinter {
	public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
		T unit = shuttle.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}

	public static void printV2(Shuttle<? extends BioUnit> shuttle) {
		BioUnit unit = shuttle.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}
}
