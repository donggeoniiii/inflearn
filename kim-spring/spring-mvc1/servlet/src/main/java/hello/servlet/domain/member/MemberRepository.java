package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public class MemberRepository {
	/**
	 * 실무에서는 동시성 문제를 위해서 concurrentHashMap, AtomicLong 등을 고려해야 함
	 */
	private Map<Long, Member> store = new HashMap<>();

	private static long sequence = 0L;

	// 싱글톤 패턴
	@Getter
	private static final MemberRepository instance = new MemberRepository();

	private MemberRepository() {}

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);

		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clear() {
		store.clear();
	}
}
