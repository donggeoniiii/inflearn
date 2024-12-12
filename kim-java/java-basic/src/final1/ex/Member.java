package final1.ex;

public class Member {
	private final String id; // id는 한번 입력되면 수정 불가능 -> final 키워드 사용
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void changeData(String id, String name) {
		// this.id = id; // id는 수정 불가라는 원칙에 맞지 않음 -> compile error
		this.name = name;
	}

	public void print() {
		System.out.println("id: " + id + ", name: " + name);
	}

}
