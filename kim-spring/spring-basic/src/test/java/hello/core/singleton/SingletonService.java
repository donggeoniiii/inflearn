package hello.core.singleton;

public class SingletonService {
	// 내부에(private) 자기 자신의 인스턴스를 하나만 가지고 있는다
	private static final SingletonService instance = new SingletonService();

	// 더 생성 못하게 private 범위로 생성자 막기
	private SingletonService() {}

	public static SingletonService getInstance() {
		return instance;
	}
}
