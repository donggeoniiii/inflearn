package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
	// 실무에선 동시성 이슈를 해결하기 위해 ConcurrentHashMap 사용
	private final Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long id) {
		return store.get(id);
	}
}
