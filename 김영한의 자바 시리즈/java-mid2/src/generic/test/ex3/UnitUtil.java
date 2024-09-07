package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitUtil {

	public static <T extends BioUnit> T maxHp(T unit1, T unit2) {
		return (unit1.getHp() >= unit2.getHp()) ? unit1 : unit2;
	}
}
