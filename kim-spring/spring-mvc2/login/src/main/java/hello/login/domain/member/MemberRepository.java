package hello.login.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * 동시성 문제는 따로 고려해야. ConcurrentHashMap & AtomicLong
 */
@Slf4j
@Repository
public class MemberRepository {

	private static final Map<Long, Member> members = new HashMap<>();

	private static long sequence = 0L;

	public Member save(Member member) {
		member.setId(++sequence);

		log.info("save: member = {}", member);
		members.put(member.getId(), member);

		return member;
	}

	public Member findById(Long id) {
		return members.get(id);
	}

	public Optional<Member> findByLoginId(String loginId) {
		return findAll().stream()
			.filter(member -> member.getLoginId().equals(loginId))
			.findFirst();
	}

	public List<Member> findAll() {
		return new ArrayList<>(members.values());
	}

	public void clear() {
		members.clear();
	}
}
