package lang.object.equals;

import java.util.Objects;

public class UserV2 {

	private String id;

	public UserV2(String id) {
		this.id = id;
	}

	// id를 기준으로 비교하도록 equals() 재정의
	@Override
	public boolean equals(Object o) {
		// 애초에 같은 객체면 true(동일성이 동등성의 상위 개념)
		if (this == o)
			return true;
		// 잘못된 접근이거나 애초에 두 객체의 클래스 정보가 다르면 false
		if (o == null || getClass() != o.getClass())
			return false;

		// id는 UserV2의 인스턴스만 갖고 있는 거니까 다운캐스팅
		UserV2 userV2 = (UserV2)o;
		return Objects.equals(id, userV2.id);
	}
}
